package com.example.musicshoponcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.musicshoponcompose.ui.theme.MusicShopOnComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicShopOnComposeTheme {
                var viewModel = viewModel<ShopViewModel>()
                //OrderSelection(viewModel)
                Navigation(viewModel = viewModel)
            }
        }
    }
}