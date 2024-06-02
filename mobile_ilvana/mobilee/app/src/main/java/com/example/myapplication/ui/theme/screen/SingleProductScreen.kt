package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.myapplication.R

@Composable
fun SingleProductScreen(navController: NavController) {
    Scaffold(
        topBar = { AppHeader(navController) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.sneakers_1_1),
                contentDescription = "Product Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(modifier = Modifier.padding(start = 10.dp, top = 5.dp)) {
                Text(
                    text = "NIKE Air Force 1 '06",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "$173.99",
                    fontSize = 20.sp,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Shine lives on in the Nike Air Force 1 '07, a basketball icon that has given a fresh twist to what you know best: sharp leather, bold colors and the perfect amount of shine to stand out.",
                    fontSize = 16.sp,
                    color = Color.Gray
                )
            }



            Spacer(modifier = Modifier.height(32.dp))

            Button(
                onClick = { /* TODO: Add to cart functionality */ },
                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
            ) {
                Text(text = "Add to cart", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}
