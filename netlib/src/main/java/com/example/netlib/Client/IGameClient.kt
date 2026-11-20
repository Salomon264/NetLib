package com.example.netlib.Client

import com.example.netlib.Model.Game
import com.example.netlib.Result.ApiResult

interface IGameClient {
    suspend fun createGame(title: String, dateTime: String, category: String): ApiResult<Game>
    suspend fun getGames(): ApiResult<List<Game>>
    suspend fun getGame(id: String): ApiResult<Game>
    suspend fun joinGame(id: String): ApiResult<Unit>
    suspend fun saveResult(gameId: String, won: Boolean, score: Int): ApiResult<Unit>
}