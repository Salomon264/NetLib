package com.example.netlib.Client

import com.example.netlib.Model.Profile
import com.example.netlib.Model.Stats
import com.example.netlib.Result.ApiResult

interface IProfileClient {
    suspend fun getProfile(): ApiResult<Profile>
    suspend fun updateProfile(name: String, avatarUrl: String?): ApiResult<Profile>
    suspend fun getStats(): ApiResult<Stats>
}