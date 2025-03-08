package com.example.gamehok.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.gamehok.R
import com.example.gamehok.viewModel.TournamentViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun logoInfo(tournamentId: Int, viewModel: TournamentViewModel = viewModel()) {
    val tournamentState by viewModel.tournament.collectAsState()

    LaunchedEffect(tournamentId) {
        viewModel.fetchTournamentById(tournamentId)
    }

    val tournament = tournamentState ?: com.example.gamehok.model.Tournament()

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.fillMaxSize()) {

            Box(modifier = Modifier.height(250.dp)) {
                GlideImage(
                    model = if (tournament.thumbnailPath.isNotEmpty()) tournament.thumbnailPath else R.drawable.pubg,
                    contentDescription = "Tournament Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 8.dp, bottom = 8.dp)
                        .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = if (tournament.registrationEndTime > System.currentTimeMillis()) "Registration Open" else "Registration Closed",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(end = 8.dp, bottom = 8.dp)
                        .background(Color.Black.copy(alpha = 0.6f), shape = RoundedCornerShape(12.dp))
                        .padding(horizontal = 12.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = "${tournament.registeredCount}/${tournament.totalCount} Players",
                        color = Color.White,
                        fontSize = 14.sp
                    )
                }
            }

            Column(modifier = Modifier.padding(16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = tournament.name.ifEmpty { "Unknown Tournament" },
                            color = Color.White,
                            fontSize = 20.sp
                        )
                        Text( modifier = Modifier.padding(top = 10.dp),
                            text = "By ${tournament.organizerDetails.name.ifEmpty { "Unknown" }}",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }

                    GlideImage(
                        model = if (tournament.organizerDetails.profileImagePath.isNotEmpty())
                            tournament.organizerDetails.profileImagePath
                        else R.drawable.pubg,
                        contentDescription = "Organizer Image",
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row {
                    Box(
                        modifier = Modifier
                            .background(Color(0xFF388E3C), shape = RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = tournament.gameName.ifEmpty { "Unknown Game" },
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Box(
                        modifier = Modifier
                            .background(Color(0xFF8D6E63), shape = RoundedCornerShape(12.dp))
                            .padding(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "Entry Fee: ${tournament.entryFees} 🪙",
                            color = Color.White,
                            fontSize = 12.sp
                        )
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))

                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(top = 4.dp, start = 8.dp, end = 8.dp)
                )
            }
        }
    }
}
