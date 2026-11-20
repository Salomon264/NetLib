package com.example.netlib.Api

import com.example.netlib.Model.Profile
import com.example.netlib.Model.Stats
import com.example.netlib.Model.UpdateProfileRequest
import retrofit2.http.Body
import retrofit2.http.GET

internal interface ProfileApi {
    @GET("users/me") suspend fun getProfile(): Profile
    @GET("users/me") suspend fun updateProfile(@Body body: UpdateProfileRequest): Profile
    @GET("users/me/stats") suspend fun getStats(): Stats
}