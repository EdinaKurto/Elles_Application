package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.rememberScrollState
import com.example.myapplication.R

@Composable
fun HomePageScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(color = Color.White)

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
            modifier = Modifier.padding(start = 90.dp, top = 20.dp, bottom = 20.dp)
        )

        ProductsRow(
            imageRes = R.drawable.newarrivals_7_1,
            brand = "Nike",
            name = "NIKE Air Force 1 '07",
            price = "$143.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductsRow(
            imageRes = R.drawable.newarrivals_3_1,
            brand = "Nike",
            name = "NIKE Air Max 95",
            price = "$261.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductsRow(
            imageRes = R.drawable.newarrivals_6_1,
            brand = "Nike",
            name = "NIKE Air Max 97",
            price = "$231.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductsRow(
            imageRes = R.drawable.newarrivals_1_1,
            brand = "Nike",
            name = "NIKE Air Force 1 '07",
            price = "$143.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductsRow(
            imageRes = R.drawable.newarrivals_4_1,
            brand = "Nike",
            name = "NIKE Air Max TN",
            price = "$173.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Featured sneakers",
            color = Color(0xff333333),
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 50.dp, top = 20.dp, bottom = 20.dp)
        )

        ProductsRow(
            imageRes = R.drawable.newarrivals_2_1,
            brand = "Nike",
            name = "NIKE Vapor Max",
            price = "$222.55"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductsRow(
            imageRes = R.drawable.sneakers_1_1,
            brand = "Nike",
            name = "NIKE Air Force 1",
            price = "$291.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductsRow(
            imageRes = R.drawable.newarrivals_5_1,
            brand = "Nike",
            name = "NIKE Air Max 95",
            price = "$231.99"
        )

        Spacer(modifier = Modifier.height(16.dp))

        ProductsRow(
            imageRes = R.drawable.newarrivals_6_1,
            brand = "Nike",
            name = "NIKE Air Max 97",
            price = "$261.99"
        )
    }
}


@Composable
fun ProductsRow(imageRes: Int, brand: String, name: String, price: String) {
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
