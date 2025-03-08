package com.example.gamehok.sections

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.gamehok.components.logoInfo
import com.example.gamehok.viewModel.TournamentViewModel

@Composable
fun TournamentDetailsScreen(navController: NavController, tournamentId: String) {
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(Color(0xFF001208))

        ) {
            val viewModel: TournamentViewModel = viewModel()
            val tournamentIdInt = tournamentId.toIntOrNull()

            tournamentIdInt?.let {
                logoInfo(tournamentId = it, viewModel = viewModel)
            } ?: run {
                Text("Invalid Tournament ID", color = Color.Red)
            }

            TournamentList(navController,tournamentId)
            Spacer(modifier = Modifier.height(100.dp))
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF001208))
                .align(Alignment.BottomCenter)
                .padding(16.dp)

        ) {
            Button(
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "JOIN TOURNAMENT",
                    color = Color.White
                )
            }
        }

    }
}


