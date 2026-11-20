package com.example.netlib.Model

import kotlinx.serialization.Serializable

@Serializable data class CreateGameRequest(
    val title: String,
    val dateTime: String,
    val category: String
)
@Serializable data class Game(
    val id: String,
    val title: String,
    val dateTime: String,
    val category: String,
    val status: String,
    val opponentId: String? = null
)
@Serializable data class GameResult(
    val won: Boolean,
    val score: Int
)
