package com.example.stockmanager.ui.navigation

sealed class Screen(val route : String){
    object Dashboard: Screen("dashboard_screen")
    object Products: Screen("products_screen")
    object Stock: Screen("stock_screen")
    object Sales: Screen("sales_screen")
    object HomePage : Screen("home_screen")
    object LoginPage : Screen("login_screen")
}
