package com.example.gamehok.Navigation

sealed class BottomNavItem(val route: String, val title: String, val icon: Int) {
    object Home : BottomNavItem("home", "Home", android.R.drawable.ic_menu_compass)
    object MyTournament : BottomNavItem("mytournament", "MyTournament", android.R.drawable.ic_menu_agenda)
    object Social : BottomNavItem("social", "Social", android.R.drawable.ic_menu_gallery)
    object Chats : BottomNavItem("chats", "Chats", android.R.drawable.ic_menu_send)
}
