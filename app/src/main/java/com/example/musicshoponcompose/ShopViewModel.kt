package com.example.musicshoponcompose

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ShopViewModel: ViewModel() {
    var phonesList = listOf("IPhone 12", "Google Pixel 7", "One Plus 10 Pro", "Samsung S21 Pro")
    /*var nameValue by remember {
        mutableStateOf("")
    }
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var selectedPhone by remember {
        mutableStateOf("IPhone 12")
    }
    val arrowRotation by animateFloatAsState(targetValue = if (isExpanded) 180f else 0f)

    var selectedMemory by remember {
        mutableStateOf(Memory.gb128)
    }*/
}