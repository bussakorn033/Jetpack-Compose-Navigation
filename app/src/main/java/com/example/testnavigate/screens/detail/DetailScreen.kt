package com.example.testnavigate.screens.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun DetailScreen(navController: NavHostController, userId: String?) {
    Column {
        Text(text = "Detail $userId")
    }
}