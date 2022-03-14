package com.example.testnavigate.screens.myNetwork

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController


@Composable
fun MyNetworkScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.LightGray)
    )
    Column {
        Text(text = "My Network Screen")
    }
}