package com.example.netlib.Client

import com.example.netlib.Api.GameApi
import com.example.netlib.Model.CreateGameRequest
import com.example.netlib.Model.Game
import com.example.netlib.Model.GameResult
import com.example.netlib.Result.ApiResult
import com.example.netlib.Result.safeCall

internal class GameClient(private val api: GameApi) : IGameClient {
    override suspend fun createGame(title: String, dateTime: String, category: String): ApiResult<Game> =
        safeCall("createGame") { api.createGame(CreateGameRequest(title, dateTime, category)) }

    override suspend fun getGames(): ApiResult<List<Game>> =
        safeCall("getGames") { api.getGames() }

    override suspend fun getGame(id: String): ApiResult<Game> =
        safeCall("getGame") { api.getGame(id) }

    override suspend fun joinGame(id: String): ApiResult<Unit> =
        safeCall("joinGame") { api.joinGame(id) }

    override suspend fun saveResult(gameId: String, won: Boolean, score: Int): ApiResult<Unit> =
        safeCall("saveResult") { api.saveResult(gameId, GameResult(won, score)) }
}