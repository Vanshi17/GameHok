package com.example.gamehok.sections

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.skydoves.landscapist.glide.GlideImage
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun PeopleToFollow() {
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
            Text(
                text = "People to follow",
                color = Color.White,
                fontSize = 18.sp
            )
            Text(
                text = "View More",
                color = Color.Green,
                fontSize = 16.sp,
                modifier = Modifier.clickable { }
            )
        }

        val peopleList = listOf(
            Person("Legend Gamer 1", "https://randomuser.me/api/portraits/women/1.jpg"),
            Person("Legend Gamer 2", "https://randomuser.me/api/portraits/men/2.jpg"),
            Person("Legend Gamer 3", "https://randomuser.me/api/portraits/women/3.jpg")
        )

        peopleList.forEach { person ->
            PersonRow(person)
        }
    }
}

@Composable
fun PersonRow(person: Person) {
    var isFollowing by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            imageModel = { person.imageUrl },
            modifier = Modifier
                .size(50.dp)
                .clip(RoundedCornerShape(50))
        )

        Text(
            text = person.name,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .weight(1f)
                .padding(start = 12.dp)
        )

        Button(
            onClick = { isFollowing = !isFollowing },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(9,52,27,255)
            ),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.size(100.dp, 40.dp)
        ) {
            Text(text = if (isFollowing) "Unfollow" else "Follow", color = Color.White, fontSize = 12.sp)
        }
    }
}

data class Person(val name: String, val imageUrl: String)

@Preview
@Composable
fun People()
{
    PeopleToFollow()
}
