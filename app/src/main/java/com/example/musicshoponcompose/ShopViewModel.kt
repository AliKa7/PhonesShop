package com.example.musicshoponcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class ShopViewModel: ViewModel() {
    object Memory {
        const val gb128 = "128"
        const val gb256 = "256"
    }

    var phonesList = listOf("IPhone 12", "Google Pixel 7", "One Plus 10 Pro", "Samsung S21 Pro")
    var nameValue by mutableStateOf("")

    var selectedPhone by mutableStateOf("IPhone 12")

    //val arrowRotation by animateFloatAsState(targetValue = if (isExpanded) 180f else 0f)

    var selectedMemory by mutableStateOf(Memory.gb128)
    var cost by mutableStateOf("1000$")
    var pathToImage by mutableStateOf(
        when(selectedPhone) {
            "IPhone 12" -> R.drawable.iphone
            "Google Pixel 7" -> R.drawable.pixel
            "One Plus 10 Pro" -> R.drawable.oneplus
            "Samsung S21 Pro" -> R.drawable.samsung
            else -> R.drawable.nokia
        }
    )
    fun onSelectedPhoneChanged(selectedPhone:String) {
        this.selectedPhone = selectedPhone
        this.pathToImage = when(selectedPhone) {
            "IPhone 12" -> R.drawable.iphone
            "Google Pixel 7" -> R.drawable.pixel
            "One Plus 10 Pro" -> R.drawable.oneplus
            "Samsung S21 Pro" -> R.drawable.samsung
            else -> R.drawable.nokia
        }
        /*cost = when(selectedMemory) {
            Memory.gb128 -> {
                when(selectedPhone) {
                    "IPhone 12" -> "1000$"
                    "Google Pixel 7" -> "500$"
                    "One Plus 10 Pro" -> "700$"
                    "Samsung S21 Pro" -> "100$"
                    else -> "-128$"
                }
            }
            Memory.gb256 -> {
                when(selectedPhone) {
                    "IPhone 12" -> "1350$"
                    "Google Pixel 7" -> "750$"
                    "One Plus 10 Pro" -> "900$"
                    "Samsung S21 Pro" -> "200$"
                    else -> "-256$"
                }
            }
            else -> "-516$"
        }*/
        CalculateCost()
    }
    fun onMemoryChanged(selectedMemory:String) {
        if (selectedMemory=="128") {
            this.selectedMemory = Memory.gb128
        }
        else if (selectedMemory=="256") {
            this.selectedMemory = Memory.gb256
        }
        CalculateCost()
    }
    fun CalculateCost() {
        this.cost = when(this.selectedMemory) {
            Memory.gb128 -> {
                when(this.selectedPhone) {
                    "IPhone 12" -> "1000$"
                    "Google Pixel 7" -> "500$"
                    "One Plus 10 Pro" -> "700$"
                    "Samsung S21 Pro" -> "100$"
                    else -> "-128$"
                }
            }
            Memory.gb256 -> {
                when(this.selectedPhone) {
                    "IPhone 12" -> "1350$"
                    "Google Pixel 7" -> "750$"
                    "One Plus 10 Pro" -> "900$"
                    "Samsung S21 Pro" -> "200$"
                    else -> "-256$"
                }
            }
            else -> "-516$"
        }
    }
}