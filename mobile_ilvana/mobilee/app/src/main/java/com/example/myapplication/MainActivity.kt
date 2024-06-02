package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.screen.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute !in listOf("login", "registration", "admin_login")) {
                AppHeader(navController)
            }
        }


    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "login",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomePageScreen() }
            composable("shop") { ShopPageScreen() }
            composable("about") { AboutUsScreen() }
            composable("cart") { CartScreen(navController) }
            composable("single_product") { SingleProductScreen(navController) }
            composable("checkout") { CheckoutScreen(navController) }
            composable("login") { LoginScreen(navController) }
            composable("registration") { RegistrationScreen(navController) }
            composable("profile") { ProfileScreen() }

        }
    }
}
