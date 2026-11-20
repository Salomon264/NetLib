package com.example.netlib.Client

import com.example.netlib.Model.AuthResponse
import com.example.netlib.Result.ApiResult

interface IAuthClient {
    suspend fun login(email: String, password: String): ApiResult<AuthResponse>
    suspend fun register(email: String, password: String, name: String): ApiResult<AuthResponse>
    suspend fun logout(): ApiResult<Unit>
}