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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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

data class Product(val id: Int, val imageRes: Int, val brand: String, val name: String, val price: String)

val products = listOf(
    Product(1, R.drawable.newarrivals_1_1, "Nike", "NIKE Air Force 1 '07", "$143.99"),
    Product(2, R.drawable.newarrivals_2_1, "Nike", "NIKE Air Max 95", "$261.99"),
    Product(3, R.drawable.newarrivals_3_1, "Nike", "NIKE Air Max 97", "$231.99"),
    Product(4, R.drawable.newarrivals_4_1, "Nike", "NIKE Air Force 1 '07", "$143.99"),
    Product(5, R.drawable.newarrivals_5_1, "Nike", "NIKE Air Max TN", "$173.99"),
    Product(6, R.drawable.newarrivals_6_1, "Nike", "NIKE Vapor Max", "$222.55"),
    Product(7, R.drawable.newarrivals_7_1, "Nike", "NIKE Air Force 1", "$291.99"),
    Product(8, R.drawable.sneakers_1_1, "Nike", "NIKE Air Max 95", "$231.99")
)

@Composable
fun HomePageScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bannerhomepagee),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        Text(
            text = "New arrivals",
            color = Color(0xff333333),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 80.dp, top = 20.dp, bottom = 20.dp)
        )

        products.forEach { product ->
            ProductItem(
                imageRes = product.imageRes,
                brand = product.brand,
                name = product.name,
                price = product.price,
                navController = navController
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProductItem(
    imageRes: Int,
    brand: String,
    name: String,
    price: String,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { navController.navigate(NavigationRoutes.ProductDetail.createRoute(1)) }
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = name,
            modifier = Modifier
                .size(120.dp)
                .padding(end = 16.dp)
        )
        Column {
            Text(
                text = brand,
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = name,
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
            Text(
                text = price,
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}