package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.compose.foundation.clickable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(navController: NavController) {
    TopAppBar(
        title = {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Home",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.navigate("home") }
                )
                Text(
                    text = "Shop",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.navigate("shop") }
                )
                Text(
                    text = "About",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.navigate("about") }
                )
                Text(
                    text = "Cart",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.navigate("cart") }
                )
                Text(
                    text = "Profile",
                    color = Color.White,
                    fontSize = 18.sp,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable { navController.navigate("profile") }
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Gray)
    )
}
