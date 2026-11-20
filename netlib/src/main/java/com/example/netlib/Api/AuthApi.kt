package com.example.netlib.Api

import com.example.netlib.Model.AuthResponse
import com.example.netlib.Model.LoginRequest
import com.example.netlib.Model.RegisterRequest
import retrofit2.http.Body
import retrofit2.http.POST

internal interface AuthApi {
    @POST("auth/login") suspend fun login(@Body body: LoginRequest): AuthResponse
    @POST("auth/register") suspend fun register(@Body body: RegisterRequest): AuthResponse
    @POST("auth/logout") suspend fun logout()
}