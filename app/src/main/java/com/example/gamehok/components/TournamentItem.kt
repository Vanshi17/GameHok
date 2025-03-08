package com.example.gamehok.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.gamehok.R
import com.example.gamehok.model.Tournament
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TournamentItem(tournament: Tournament, onClick: () -> Unit) {
    val currentTime = System.currentTimeMillis()
    val registrationStatus = if (tournament.registrationEndTime > currentTime) {
        "Closes in ${formatTimeDifference(tournament.registrationEndTime - currentTime)}"
    } else {
        "Registration Closed"
    }

    Box(
        modifier = Modifier
            .width(300.dp)
            .height(400.dp)
            .padding(4.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(
                Brush.linearGradient(
                    colors = listOf(Color(104, 185, 138, 255), Color(9, 52, 27, 255))
                )
            )
            .clickable { onClick() }
            .border(0.5.dp, Color.White, RoundedCornerShape(12.dp))
    ) {
        GlideImage(
            model = tournament.thumbnailPath.ifEmpty { "https://assets-prd.ignimgs.com/2024/08/27/pubg-7th-anniversary-key-art-1724780016773.jpg" },
            contentDescription = "Tournament Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (tournament.registrationEndTime > currentTime) Color.Green else Color.Red)
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = registrationStatus,
                    color = Color.White,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(Color.Black.copy(alpha = 0.7f))
                    .padding(horizontal = 8.dp, vertical = 4.dp)
            ) {
                Text(
                    text = "${tournament.registeredCount}/${tournament.totalCount}",
                    color = Color.White,
                    fontSize = 12.sp
                )
            }
        }

        Box(modifier = Modifier.offset(x = 220.dp, y = 170.dp)) {
            GlideImage(
                model = tournament.organizerDetails.profileImagePath.ifEmpty { R.drawable.pubg },
                contentDescription = "Organizer Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
            )
        }

        Column(modifier = Modifier.padding(12.dp).offset(y = 200.dp)) {

            Text(
                modifier = Modifier.padding(top = 5.dp),
                text = tournament.name,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "By ${tournament.organizerDetails.name.ifEmpty { "Unknown Organizer" }}",
                color = Color.White,
                fontSize = 14.sp
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 14.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                TournamentTag(text = tournament.gameName)
                TournamentTag(text = tournament.teamSize)
                TournamentTag(text = "Entry-${tournament.entryFees} 🪙")
            }

            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {
                Text(
                    text = "⏰ Starts ${formatDate(tournament.tournamentStartTime)}",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Text(
                    modifier = Modifier.padding(top = 8.dp),
                    text = "🏆 Prize Pool- ${tournament.prizeCoins} 🪙",
                    color = Color.Yellow,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Composable
fun TournamentTag(text: String) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0xFF2E7D32))
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(text = text, color = Color.White, fontSize = 15.sp)
    }
}

fun formatDate(timestamp: Long): String {
    return SimpleDateFormat("d MMM 'at' hh:mm a", Locale.getDefault()).format(Date(timestamp))
}

fun formatTimeDifference(milliseconds: Long): String {
    val hours = milliseconds / (1000 * 60 * 60)
    val minutes = (milliseconds / (1000 * 60)) % 60
    return if (hours > 0) "$hours hrs $minutes mins" else "$minutes mins"
}
