package com.example.netlib.Model

import kotlinx.serialization.Serializable

@Serializable data class Profile(
    val id: String,
    val name: String,
    val email: String,
    val avatarUrl: String? = null
)
@Serializable data class UpdateProfileRequest(val name: String, val avatarUrl: String? = null)
@Serializable data class Stats(
    val weeklyEarnings: Int = 0,
    val playedGames: Int = 0,
    val scheduledGames: Int = 0
)