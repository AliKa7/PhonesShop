package com.example.musicshoponcompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
@Composable
fun Navigation(viewModel: ShopViewModel) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.OrderSelection.route) {
        composable(route = Screen.Cart.route) {
            Cart(viewModel = viewModel, navController = navController)
        }
        composable(route = Screen.OrderSelection.route) {
            OrderSelection(viewModel = viewModel, navController = navController)
        }
    }

}