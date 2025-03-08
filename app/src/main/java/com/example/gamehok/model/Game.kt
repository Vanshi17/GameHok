package com.example.gamehok.model

import com.google.gson.annotations.SerializedName

data class Game(
    @SerializedName("id") val id: Int,
    @SerializedName("gameName") val gameName: String,
    @SerializedName("imagePath") val imagePath: String
)