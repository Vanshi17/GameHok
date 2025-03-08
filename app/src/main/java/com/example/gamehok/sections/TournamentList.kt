package com.example.gamehok.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gamehok.api.RetrofitInstance
import com.example.gamehok.components.TournamentItem
import com.example.gamehok.model.Tournament

@Composable
fun TournamentList(navController: NavController, tournamentId: String) {
    var tournaments by remember { mutableStateOf<List<Tournament>>(emptyList()) }

    LaunchedEffect(Unit) {
        try {
            tournaments = RetrofitInstance.api.getTournaments()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    val filteredTournaments = tournaments.filter { it.id.toString() != tournamentId }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 20.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Compete in Battles",
                color = Color.White,
                fontSize = 18.sp
            )
            Text(
                text = "View All",
                color = Color.Green,
                fontSize = 16.sp,
                modifier = Modifier.clickable { }
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(filteredTournaments) { tournament ->
                TournamentItem(
                    tournament = tournament,
                    onClick = {
                        navController.navigate("tournamentDetails/${tournament.id}")
                    }
                )
            }
        }
    }
}
