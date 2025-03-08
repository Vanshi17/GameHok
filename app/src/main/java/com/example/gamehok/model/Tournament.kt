package com.example.gamehok.model

data class Tournament(
    val id: Int = 0,
    val name: String = "Unknown Tournament",
    val thumbnailPath: String = "https://assets-prd.ignimgs.com/2024/08/27/pubg-7th-anniversary-key-art-1724780016773.jpg",
    val entryFees: Int = 0,
    val prizeCoins: String = "Not Available",
    val tournamentStartTime: Long = 0L,
    val registrationEndTime: Long = 0L,
    val organizerDetails: Organizer = Organizer(),
    val status: String = "Unknown",
    val gameName: String = "Unknown Game",
    val teamSize: String = "Unknown",
    val registeredCount: Int = 0,
    val totalCount: Int = 0
)

data class Organizer(
    val id: String = "",
    val name: String = "Unknown Organizer",
    val profileImagePath: String = ""
)
