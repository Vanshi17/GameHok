package com.example.gamehok.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gamehok.components.TopStatusBar
import com.example.gamehok.sections.PeopleToFollow
import com.example.gamehok.sections.PremiumAdCard
import com.example.gamehok.sections.TournamentList
import com.example.gamehok.sections.TournamentSection

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        topBar = { TopStatusBar() },
        containerColor = Color(0xFF001208)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                PremiumAdCard()
                TournamentSection(onGameClick = { game ->
                    println("$game Clicked")
                })

                TournamentList(navController,"")
                PeopleToFollow()
                Spacer(modifier = Modifier.size(100.dp))
            }
        }
    }}
