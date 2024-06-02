package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.navigation.NavigationRoutes
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.screen.AppHeader
import com.example.myapplication.ui.theme.screen.CartScreen
import com.example.myapplication.ui.theme.screen.CheckoutScreen
import com.example.myapplication.ui.theme.screen.HomePageScreen
import com.example.myapplication.ui.theme.screen.LoginScreen
import com.example.myapplication.ui.theme.screen.RegistrationScreen
import com.example.myapplication.ui.theme.screen.ShopPageScreen
import com.example.myapplication.ui.theme.screen.SingleProductScreen


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
            startDestination = NavigationRoutes.Login.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavigationRoutes.Home.route) {HomePageScreen(navController) }
            composable(NavigationRoutes.ShopPage.route) { ShopPageScreen(navController) }
            composable(NavigationRoutes.Cart.route) { CartScreen(navController) }
            composable(
                route = NavigationRoutes.ProductDetail.route,
                arguments = listOf(navArgument("productId") { type = NavType.IntType })
            ) { backStackEntry ->
                val productId = backStackEntry.arguments?.getInt("productId") ?: -1
                SingleProductScreen(navController, productId)
            }
            composable(NavigationRoutes.Checkout.route) { CheckoutScreen(navController) }
            composable(NavigationRoutes.Login.route) { LoginScreen(navController) }
            composable(NavigationRoutes.Registration.route) { RegistrationScreen(navController) }
        }
    }
}




