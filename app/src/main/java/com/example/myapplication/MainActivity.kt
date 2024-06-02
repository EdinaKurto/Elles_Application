package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.model.model.AppDatabase
import com.example.myapplication.model.model.repositories.UserRepository
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.theme.screen.*
import com.example.myapplication.navigation.NavigationRoutes
import com.example.myapplication.ui.viewmodel.LoginViewModel
import com.example.myapplication.ui.viewmodel.ProfileViewModel
import com.example.myapplication.ui.viewmodel.RegistrationViewModel
import com.example.myapplication.ui.viewmodel.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userRepository = UserRepository(AppDatabase.getDatabase(applicationContext).userDao())

        val loginViewModel: LoginViewModel by viewModels { ViewModelFactory(userRepository) }
        val registrationViewModel: RegistrationViewModel by viewModels { ViewModelFactory(userRepository) }
        val profileViewModel: ProfileViewModel by viewModels { ViewModelFactory(userRepository) }

        setContent {
            MyApplicationTheme {
                MainScreen(
                    navController = rememberNavController(),
                    loginViewModel,
                    registrationViewModel,
                    profileViewModel
                )
            }
        }
    }
}

@Composable
fun MainScreen(
    navController: NavHostController,
    loginViewModel: LoginViewModel,
    registrationViewModel: RegistrationViewModel,
    profileViewModel: ProfileViewModel
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        topBar = {
            if (currentRoute !in listOf(NavigationRoutes.Login.route, NavigationRoutes.Registration.route, NavigationRoutes.AdminLogin.route)) {
                AppHeader(navController)
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavigationRoutes.Registration.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(NavigationRoutes.Home.route) { HomePageScreen(navController) }
            composable(NavigationRoutes.ShopPage.route) { ShopPageScreen(navController) }
            composable(NavigationRoutes.AboutUs.route) { AboutUsScreen() }
            composable(NavigationRoutes.Cart.route) { CartScreen(navController) }
            composable(NavigationRoutes.ProductDetail.route) { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull() ?: return@composable
                SingleProductScreen(navController, productId)
            }
            composable(NavigationRoutes.Checkout.route) { CheckoutScreen(navController) }
            composable(NavigationRoutes.Login.route) { LoginScreen(navController, loginViewModel) }
            composable(NavigationRoutes.Registration.route) { RegistrationScreen(navController, registrationViewModel) }
            composable(NavigationRoutes.Profile.route) { ProfileScreen(navController, profileViewModel) }
        }
    }
}
