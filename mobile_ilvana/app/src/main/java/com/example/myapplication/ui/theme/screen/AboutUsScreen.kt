package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun AboutUsScreen(navController: NavController) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp)
        ) {
            Text(
                text = "About Us",
                color = Color(0xff666666),
                fontSize = 25.sp
            )
            Text(
                text = "\n\nWelcome to Elles - your destination for premium Nike sneakers for every occasion. At Elles, the passion for innovative design, top-notch quality, and unparalleled comfort of the Nike brand is combined with our commitment to providing excellent service and shopping experience.\n\nThrough our wide range of Nike sneakers, we offer the latest models and iconic styles that suit every occasion - from sports activities to casual everyday wear and everything in between. Whether you're a running enthusiast, fitness fanatic, or simply love a modern.",
                color = Color(0xff666666),
                fontSize = 16.sp
            )
        }
}
