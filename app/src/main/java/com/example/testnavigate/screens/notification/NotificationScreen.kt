package com.example.testnavigate.screens.notification

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
fun NotificationScreen(navController: NavHostController) {
    Box(
        modifier = Modifier.fillMaxSize().background(Color.Green)
    ) {
        Column {
            Text(text = "Notification Screen")
        }
    }
}