package com.example.netlib.Client

import com.example.netlib.Api.ProfileApi
import com.example.netlib.Model.Profile
import com.example.netlib.Model.Stats
import com.example.netlib.Model.UpdateProfileRequest
import com.example.netlib.Result.ApiResult
import com.example.netlib.Result.safeCall

internal class ProfileClient(private val api: ProfileApi) : IProfileClient {
    override suspend fun getProfile(): ApiResult<Profile> =
        safeCall("getProfile") { api.getProfile() }

    override suspend fun updateProfile(name: String, avatarUrl: String?): ApiResult<Profile> =
        safeCall("updateProfile") { api.updateProfile(UpdateProfileRequest(name, avatarUrl)) }

    override suspend fun getStats(): ApiResult<Stats> =
        safeCall("getStats") { api.getStats() }
}