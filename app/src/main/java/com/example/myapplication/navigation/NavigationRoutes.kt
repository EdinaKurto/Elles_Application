package com.example.myapplication.navigation

sealed class NavigationRoutes(val route: String) {
    object Home : NavigationRoutes("home")
    object ShopPage : NavigationRoutes("shop")
    object AboutUs : NavigationRoutes("about")
    object Cart : NavigationRoutes("cart")
    object ProductDetail : NavigationRoutes("single_product/{productId}") {
        fun createRoute(productId: Int) = "single_product/$productId"
    }
    object Checkout : NavigationRoutes("checkout")
    object Login : NavigationRoutes("login")
    object Registration : NavigationRoutes("registration")
    object AdminLogin : NavigationRoutes("admin_login")
    object Profile : NavigationRoutes("profile")
}

