package com.example.gamehok.api

import com.example.gamehok.model.Game
import retrofit2.http.GET

interface GameService {
    @GET("games")
    suspend fun getGames(): List<Game>
}
