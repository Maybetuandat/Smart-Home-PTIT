package com.example.smarthomeptit.navigation

import com.example.smarthomeptit.R

sealed class BottomNavItem(var label:String, var icon: Int, var route: String) {
    object Home:BottomNavItem("Home", R.drawable.home, "home")
    object Device:BottomNavItem("Device", R.drawable.device, "device")
    object History:BottomNavItem("History", R.drawable.history, "history")
    object Profile:BottomNavItem("Profile", R.drawable.profile, "profile")
}