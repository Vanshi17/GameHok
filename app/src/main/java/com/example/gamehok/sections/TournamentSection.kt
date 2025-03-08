package com.example.gamehok.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gamehok.R
import com.example.gamehok.model.Game
import com.example.gamehok.viewModel.GameViewModel
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun TournamentSection(viewModel: GameViewModel = GameViewModel(), onGameClick: (String) -> Unit) {
    val games by viewModel.games.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Play Tournament by Games", color = Color.White, fontSize = 18.sp)
            Text(
                text = "View All",
                color = Color.Green,
                fontSize = 16.sp,
                modifier = Modifier.clickable { }
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            games.take(3).forEach { game ->
                GameItem(game, onGameClick)
            }
        }
    }

    Divider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.padding(top = 4.dp, start = 16.dp, end = 16.dp)
    )
}

@Composable
fun GameItem(game: Game, onGameClick: (String) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onGameClick(game.gameName) }
    ) {
        GlideImage(
            imageModel = { game.imagePath },
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp)),
            failure = {
                GlideImage(
                    imageModel = { R.drawable.pubg },
                    modifier = Modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(12.dp))
                )
            }
        )
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = game.gameName, color = Color.White, fontSize = 14.sp)
    }
}
