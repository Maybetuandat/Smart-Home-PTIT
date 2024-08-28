package com.example.smarthomeptit
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

import com.example.smarthomeptit.R
import com.example.smarthomeptit.model.NavItem
import com.example.smarthomeptit.pages.*

import com.example.smarthomeptit.ui.theme.BackgroundColor
import com.example.smarthomeptit.ui.theme.colorOrange
import com.example.smarthomeptit.ui.theme.iconselectedcolor
import com.example.smarthomeptit.ui.theme.iconunselectedcolor


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            MainScreen()

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navItemList = listOf(
        NavItem("Home", painterResource(id = R.drawable.home)),
        NavItem("Devices", painterResource(id = R.drawable.device)),
        NavItem("History", painterResource(id = R.drawable.history)),
        NavItem("Profile", painterResource(id = R.drawable.profile))
    )
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    Scaffold(modifier = Modifier.fillMaxSize(),

        bottomBar =
        {
            NavigationBar(
                containerColor = BackgroundColor

            )
            {
                navItemList.forEachIndexed { index, navItem ->
                    NavigationBarItem(
                        selected = selectedIndex == index,
                        onClick =
                        {
                            selectedIndex = index
                        },
                        icon =
                        {
                            Icon(painter = navItem.icon, contentDescription = "Icon")
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


    )
    { innerPadding ->
        ContentScreen(modifier = Modifier.padding(innerPadding), selectedIndex)
    }

    //  cấu trúc của một đối tượng trong compose
    // tên đối tượng () {}
    // ở trong dấu () sẽ sử dụng để định dạng các thuộc tính cho đối tượng đó
    // trong dấu {} sử dụng để bao gồm các đối tượng con, ví dụ như trong các layout sẽ bao gồm các đối tượng như text view hay button
    // đối với Scaffold(), cos thể  su dụng các đối tượng nằm bên trong như topbar, bottom bar ở trong ngoặc () để định nghĩa các đối tượng con
}

@Composable
fun ContentScreen(modifier: Modifier, selectedIndex: Int) {
  Box(modifier = modifier)
  {
      when (selectedIndex) {
          0 -> HomePage()
          1 -> Device()
          2 -> History()
          3 -> ProfilePage()
      }
  }


}