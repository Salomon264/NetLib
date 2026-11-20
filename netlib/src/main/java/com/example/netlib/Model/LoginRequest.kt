package com.example.netlib.Model

import kotlinx.serialization.Serializable

@Serializable data class LoginRequest(
    val email: String,
    val password: String
)