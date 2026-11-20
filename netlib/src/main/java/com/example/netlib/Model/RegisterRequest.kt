package com.example.netlib.Model

import android.provider.ContactsContract
import kotlinx.serialization.Serializable

@Serializable data class RegisterRequest(
    val email: String,
    val password: String,
    val name: String
)