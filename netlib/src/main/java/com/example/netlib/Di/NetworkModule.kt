package com.example.netlib.Di

import com.example.netlib.Api.AuthApi
import com.example.netlib.Api.GameApi
import com.example.netlib.Api.ProfileApi
import com.example.netlib.Client.AuthClient
import com.example.netlib.Client.GameClient
import com.example.netlib.Client.ProfileClient
import com.example.netlib.Config.NetworkConfig
import com.example.netlib.Session.SessionStore
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

object NetworkModule {
    fun create(config: NetworkConfig): NetworkFacade {
        val session = SessionStore()

        val headers = Interceptor { chain ->
            val request = chain.request().newBuilder()
                .header("X-Api-Key", config.apiKey)
                .apply { session.token?.let { header("Authorization", "Bearer $it") } }
                .build()
            chain.proceed(request)
        }

        val client = OkHttpClient.Builder()
            .connectTimeout(config.timeOutSec, TimeUnit.SECONDS)
            .readTimeout(config.timeOutSec, TimeUnit.SECONDS)
            .addInterceptor(headers)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(config.baseUrl)
            .client(client)
            .addConverterFactory(
                Json { ignoreUnknownKeys = true }.asConverterFactory("application/json".toMediaType())
            )
            .build()

        return NetworkFacade(
            auth = AuthClient(retrofit.create(), session),
            profile = ProfileClient(retrofit.create()),
            game = GameClient(retrofit.create()),
            session = session,
        )
    }
}