package com.example.stockmanager.ui.navigation

import com.example.stockmanager.R

data class Menu(val name : String, val icon: Int, val route : String)

val mainPageNavList = listOf(
    Menu("Dashboard", R.drawable.ic_report, Screen.Dashboard.route),
    Menu("Sales", R.drawable.ic_coupon, Screen.Sales.route),
    Menu("Products", R.drawable.ic_product, Screen.Products.route),
    Menu("Stock", R.drawable.ic_stock, Screen.Stock.route),
)