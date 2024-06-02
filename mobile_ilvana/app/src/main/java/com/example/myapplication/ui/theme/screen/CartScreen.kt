package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun CartScreen(navController: NavController) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.cartbanner), // Zamijenite sa stvarnim ID-om vaše slike
            contentDescription = "Header Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductRow(
            productImage = R.drawable.newarrivals_2_1,
            productName = "NIKE Air Force 1",
            productPrice = "$143.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductRow(
            productImage = R.drawable.newarrivals_1_1,
            productName = "NIKE Air Max TN",
            productPrice = "$143.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductRow(
            productImage = R.drawable.newarrivals_6_1,
            productName = "NIKE Air Force 2",
            productPrice = "$143.99"
        )

        Spacer(modifier = Modifier.height(32.dp))

        CartTotal()

        Spacer(modifier = Modifier.height(16.dp))

        Box(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { navController.navigate("checkout") },
                colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)),
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .align(Alignment.Center)
                    .width(200.dp)
                    .height(50.dp)
                    .padding(bottom = 10.dp)
            ) {
                Text(text = "Proceed to checkout", color = Color.White, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun ProductRow(productImage: Int, productName: String, productPrice: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 5.dp, end = 5.dp)
    ) {
        Image(
            painter = painterResource(id = productImage),
            contentDescription = "Product Image",
            modifier = Modifier
                .size(140.dp) // Povećaj veličinu slike
                .padding(end = 16.dp),
            contentScale = ContentScale.Fit // Promjena iz Crop u Fit
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = productName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = productPrice,
                fontSize = 16.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun CartTotal() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(8.dp))
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Cart Subtotal",
                fontSize = 16.sp
            )
            Text(
                text = "$431.97",
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Shipping",
                fontSize = 16.sp
            )
            Text(
                text = "Free",
                fontSize = 16.sp
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Total",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "$431.97",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
