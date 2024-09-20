package com.example.smarthomeptit.ui.page

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.smarthomeptit.NavigationHost
import com.example.smarthomeptit.navigation.BottomNavigation
import com.example.smarthomeptit.viewModel.HomeViewModel

@Composable
fun MainScreen(viewModel: HomeViewModel) {
    val navController = rememberNavController()
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar =
        {
            BottomNavigation(navController)
        }
    )
    { innerPadding ->
        NavigationHost(viewModel,Modifier.padding(innerPadding), navController)
    }
}

