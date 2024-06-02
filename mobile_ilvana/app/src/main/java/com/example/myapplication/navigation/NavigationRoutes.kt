package com.example.myapplication.navigation

sealed class NavigationRoutes(val route: String) {
    object Home : NavigationRoutes("home")
    object ShopPage : NavigationRoutes("shop")
    object AboutUs : NavigationRoutes("about")
    object Cart : NavigationRoutes("cart")
    object ProductDetail : NavigationRoutes("product_detail/{productId}") {
        fun createRoute(productId: Int) = "product_detail/$productId"
    }
    object Checkout : NavigationRoutes("checkout")
    object Login : NavigationRoutes("login")
    object Registration : NavigationRoutes("registration")
    object AdminLogin : NavigationRoutes("admin_login")
    object EditAdmin : NavigationRoutes("edit_admin")
}