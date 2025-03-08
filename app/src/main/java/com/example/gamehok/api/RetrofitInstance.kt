package com.example.gamehok.api

import com.example.gamehok.model.Game
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://67c9566f0acf98d07089d293.mockapi.io/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

class GameRepository {
    private val api: GameService

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://67c9566f0acf98d07089d293.mockapi.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(GameService::class.java)
    }

    suspend fun getGames(): List<Game> {
        return try {
            api.getGames()
        } catch (e: Exception) {
            emptyList()
        }
    }
}