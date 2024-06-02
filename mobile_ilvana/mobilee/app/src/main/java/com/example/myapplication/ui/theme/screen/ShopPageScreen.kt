package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R


data class Product(val imageRes: Int, val brand: String, val name: String, val price: String)

val products = listOf(
    Product(R.drawable.newarrivals_1_1, "Nike", "NIKE Air Force 1 '07", "$143.99"),
    Product(R.drawable.newarrivals_2_1, "Nike", "NIKE Air Max 95", "$261.99"),
    Product(R.drawable.newarrivals_3_1, "Nike", "NIKE Air Max 97", "$231.99"),
    Product(R.drawable.newarrivals_4_1, "Nike", "NIKE Air Force 1 '07", "$143.99"),
    Product(R.drawable.newarrivals_5_1, "Nike", "NIKE Air Max TN", "$173.99"),
    Product(R.drawable.newarrivals_6_1, "Nike", "NIKE Vapor Max", "$222.55"),
    Product(R.drawable.newarrivals_7_1, "Nike", "NIKE Air Force 1", "$291.99"),
    Product(R.drawable.sneakers_1_1, "Nike", "NIKE Air Max 95", "$231.99")
)

@Composable
fun ShopPageScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)

    ) {
        item {
            Image(
                painter = painterResource(id = R.drawable.bannershoppage),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }

        items(products) { product ->
            ProductRow(
                imageRes = product.imageRes,
                brand = product.brand,
                name = product.name,
                price = product.price
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProductRow(imageRes: Int, brand: String, name: String, price: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(140.dp)
                .padding(end = 16.dp)
        )
        Column {
            Text(
                text = brand,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(top = 20.dp)
            )
            Text(
                text = name,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = price,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
