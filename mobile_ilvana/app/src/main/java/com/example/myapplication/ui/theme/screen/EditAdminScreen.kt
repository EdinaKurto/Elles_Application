package com.example.myapplication.ui.theme.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
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

data class AdminProduct(val id: Int, val imageRes: Int, val name: String, val price: String)

@Composable
fun EditAdminScreen(navController: NavController) {
    var products by remember { mutableStateOf(sampleProducts.toMutableList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { products = products.toMutableList().apply { add(AdminProduct(products.size, R.drawable.newarrivals_2_1, "New Product", "$0.00")) } },
            colors = ButtonDefaults.buttonColors(Color(0xFF4CAF50)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .height(50.dp)
        ) {
            Text("ADD+")
        }

        LazyColumn {
            items(products) { product ->
                AdminProductCard(product, onEdit = { id ->
                    // Handle edit action
                    products = products.map {
                        if (it.id == id) it.copy(name = "Edited Product") else it
                    }.toMutableList()
                }, onDelete = { id ->
                    // Handle delete action
                    products = products.filter { it.id != id }.toMutableList()
                })
            }
        }
    }
}

@Composable
fun AdminProductCard(product: AdminProduct, onEdit: (Int) -> Unit, onDelete: (Int) -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Nike",
                fontSize = 16.sp,
                color = Color.Gray,
                fontWeight = FontWeight.Light
            )
            Text(
                text = product.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = product.price,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFFE53935)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = { onEdit(product.id) },
                    colors = ButtonDefaults.buttonColors(Color(0xFF42A5F5)),
                    modifier = Modifier.weight(1f).padding(4.dp)
                ) {
                    Text("EDIT")
                }
                Button(
                    onClick = { onDelete(product.id) },
                    colors = ButtonDefaults.buttonColors(Color(0xFFE53935)),
                    modifier = Modifier.weight(1f).padding(4.dp)
                ) {
                    Text("DELETE")
                }
            }
        }
    }
}

val sampleProducts = listOf(
    AdminProduct(0, R.drawable.newarrivals_2_1, "NIKE Air Max TN", "$173.99"),
    AdminProduct(1, R.drawable.newarrivals_1_1, "NIKE Air Max 95", "$173.99"),
    AdminProduct(2, R.drawable.newarrivals_6_1, "NIKE Vapor Max", "$222.55"),
    AdminProduct(3, R.drawable.sneakers_1_1, "NIKE Air Force 1", "$291.99")
)
