package com.example.netlib.Client

import com.example.netlib.Api.AuthApi
import com.example.netlib.Model.AuthResponse
import com.example.netlib.Model.LoginRequest
import com.example.netlib.Model.RegisterRequest
import com.example.netlib.Result.ApiResult
import com.example.netlib.Result.safeCall
import com.example.netlib.Session.SessionStore

internal class AuthClient(
    private val api: AuthApi,
    private val session: SessionStore,
) : IAuthClient {

    override suspend fun login(email: String, password: String): ApiResult<AuthResponse> =
        safeCall("login") { api.login(LoginRequest(email, password)) }.also { saveSession(it) }

    override suspend fun register(email: String, password: String, name: String): ApiResult<AuthResponse> =
        safeCall("register") { api.register(RegisterRequest(email, password, name)) }.also { saveSession(it) }

    override suspend fun logout(): ApiResult<Unit> =
        safeCall("logout") { api.logout() }.also { session.clear() }

    private fun saveSession(result: ApiResult<AuthResponse>) {
        if (result is ApiResult.Success) session.save(result.data.token, result.data.userId)
    }
}