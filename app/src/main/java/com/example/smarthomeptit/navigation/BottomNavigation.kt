package com.example.smarthomeptit.navigation

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.iconselectedcolor
import com.example.smarthomeptit.ui.theme.iconunselectedcolor

@Composable
fun BottomNavigation(navController: NavController) {
    val navItemList = listOf(
        BottomNavItem.Home,
        BottomNavItem.Device,
        BottomNavItem.History,
        BottomNavItem.Profile

    )
    NavigationBar(
        containerColor = BackgroundColor
    )
    {
        val currenRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        navItemList.forEachIndexed { index, navItem ->
            NavigationBarItem(
                selected = currenRoute == navItem.route,
                onClick =
                {
                    if (currenRoute != navItem.route) {
                        navController.navigate(navItem.route)
                        {
                            popUpTo(navController.graph.startDestinationId)
                            {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon =
                {
                    Icon(painter = painterResource(id = navItem.icon), contentDescription = "Icon")
                },
                label =
                {
                    Text(text = navItem.label)
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent,
                    unselectedIconColor = iconunselectedcolor, // Màu cho icon khi không được chọn
                    selectedIconColor = iconselectedcolor,
                    unselectedTextColor = iconunselectedcolor,
                    selectedTextColor = iconselectedcolor
                ),

                )

        }

    }
}
