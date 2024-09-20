package com.example.smarthomeptit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smarthomeptit.navigation.BottomNavItem
import com.example.smarthomeptit.ui.page.DevicePage
import com.example.smarthomeptit.ui.page.HistoryPage
import com.example.smarthomeptit.ui.page.HomePage
import com.example.smarthomeptit.ui.page.ProfilePage
import com.example.smarthomeptit.viewModel.HomeViewModel

@Composable
fun NavigationHost(viewModel: HomeViewModel, modifier: Modifier, navController: NavHostController)
{
    NavHost(navController = navController,
            startDestination = BottomNavItem.Home.route,
        modifier= modifier
    ) {
        composable(BottomNavItem.Home.route)
        {
            HomePage(viewModel)
        }
        composable(BottomNavItem.Device.route)
        {
            DevicePage()
        }
        composable(BottomNavItem.History.route)
        {
            HistoryPage()
        }
        composable(BottomNavItem.Profile.route)
        {
            ProfilePage()
        }
    }
}
