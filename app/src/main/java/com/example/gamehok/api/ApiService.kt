package com.example.gamehok.api

import com.example.gamehok.model.Tournament
import retrofit2.http.GET

interface ApiService {
    @GET("tournaments")
    suspend fun getTournaments(): List<Tournament>
}
