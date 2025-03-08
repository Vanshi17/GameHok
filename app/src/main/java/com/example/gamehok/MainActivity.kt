package com.example.gamehok

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.*
import com.example.gamehok.Navigation.BottomNavItem
import com.example.gamehok.Navigation.BottomNavigationBar
import com.example.gamehok.Screens.*
import com.example.gamehok.sections.TournamentDetailsScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    val systemUiController = rememberSystemUiController()
    val navController = rememberNavController()
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    SideEffect {
        systemUiController.setStatusBarColor(
            color = Color(0xFF001208),
            darkIcons = false
        )
    }

    Scaffold(
        bottomBar = {
            if (currentRoute !in listOf("tournamentDetails/{tournamentId}")) {
                BottomNavigationBar(navController)
            }
        },
        containerColor = Color(0xFF001208)
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            NavHost(
                navController = navController,
                startDestination = BottomNavItem.Home.route,
                modifier = Modifier.fillMaxSize()
            ) {
                composable(BottomNavItem.Home.route) { HomeScreen(navController) }
                composable(BottomNavItem.MyTournament.route) { MyTournamentScreen() }
                composable(BottomNavItem.Social.route) { SocialScreen() }
                composable(BottomNavItem.Chats.route) { ChatsScreen() }


                composable("tournamentDetails/{tournamentId}") { backStackEntry ->
                    val tournamentId = backStackEntry.arguments?.getString("tournamentId") ?: ""
                    TournamentDetailsScreen(navController,tournamentId)
                }
            }
        }
    }
}




@Preview
@Composable
fun PreviewSection() {
    MainScreen()
}
