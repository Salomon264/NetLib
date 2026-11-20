package com.example.netlib.Model

import kotlinx.serialization.Serializable

@Serializable data class AuthResponse(
    val token: String,
    val userId: String
)