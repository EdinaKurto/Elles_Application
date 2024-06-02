package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.navigation.NavigationRoutes

data class Product1(val id: Int, val imageRes: Int, val brand: String, val name: String, val price: String)

val products1 = listOf(
    Product1(1, R.drawable.newarrivals_1_1, "Nike", "NIKE Air Force 1 '07", "$143.99"),
    Product1(2, R.drawable.newarrivals_2_1, "Nike", "NIKE Air Max 95", "$261.99"),
    Product1(3, R.drawable.newarrivals_3_1, "Nike", "NIKE Air Max 97", "$231.99"),
    Product1(4, R.drawable.newarrivals_4_1, "Nike", "NIKE Air Force 1 '07", "$143.99"),
    Product1(5, R.drawable.newarrivals_5_1, "Nike", "NIKE Air Max TN", "$173.99"),
    Product1(6, R.drawable.newarrivals_6_1, "Nike", "NIKE Vapor Max", "$222.55"),
    Product1(7, R.drawable.newarrivals_7_1, "Nike", "NIKE Air Force 1", "$291.99"),
    Product1(8, R.drawable.sneakers_1_1, "Nike", "NIKE Air Max 95", "$231.99")
)

@Composable
fun ShopPageScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
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

        items(products1) { product1 ->
            ProductRow(
                product1 = product1,
                onClick = {
                    navController.navigate(NavigationRoutes.ProductDetail.createRoute(product1.id))
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProductRow(product1: Product1, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable(onClick = onClick)
    ) {
        Image(
            painter = painterResource(id = product1.imageRes),
            contentDescription = product1.name,
            modifier = Modifier
                .size(140.dp)
                .padding(end = 16.dp)
        )
        Column {
            Text(
                text = product1.brand,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                modifier = Modifier
                    .padding(top = 20.dp)
            )
            Text(
                text = product1.name,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = product1.price,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}