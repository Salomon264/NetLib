package com.example.netlib.Api

import com.example.netlib.Model.CreateGameRequest
import com.example.netlib.Model.Game
import com.example.netlib.Model.GameResult
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

internal interface GameApi {
    @POST("games") suspend fun createGame(@Body body: CreateGameRequest): Game
    @GET("games") suspend fun getGames(): List<Game>
    @GET("games/{id}") suspend fun getGame(@Path("id") id: String): Game
    @POST("games/{id}/join") suspend fun joinGame(@Path("id") id: String)
    @POST("games/{id}/result") suspend fun saveResult(@Path("id") id: String, @Body body: GameResult)
}