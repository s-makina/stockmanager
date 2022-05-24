package com.example.stockmanager.ui.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.stockmanager.ui.pages.HomePage
import com.example.stockmanager.ui.pages.LoginPage
import com.example.stockmanager.ui.pages.main.Dashboard
import com.example.stockmanager.ui.pages.main.ProductsUi
import com.example.stockmanager.ui.pages.main.SalesUi
import com.example.stockmanager.ui.pages.main.StockUi

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginPage.route) {
        composable(route = Screen.LoginPage.route) {
            LoginPage(navController)
        }

        composable(route = Screen.HomePage.route) {
            HomePage(navController)
        }
//
//        composable(route = Screen.SettingsPage.route) {
//            Settings(navController)
//        }
    }
}

@Composable
fun MainPageNavigation(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        navController,
        startDestination = Screen.Dashboard.route,
        Modifier.padding(innerPadding)
    ) {

        composable(Screen.Dashboard.route) {
            Dashboard()
        }

        composable(Screen.Products.route) {
            ProductsUi()
        }

        composable(Screen.Sales.route) {
            SalesUi()
        }
        composable(Screen.Stock.route) {
            StockUi()
        }
    }
}