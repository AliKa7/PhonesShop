package com.example.musicshoponcompose

sealed class Screen(val route:String) {
    object OrderSelection:Screen(route = "order_selection_screen")
    object Cart:Screen(route = "cart_screen")
}
