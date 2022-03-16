package com.example.testnavigate.screens.add

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController


@Composable
fun AddScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Cyan)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        Column (
            modifier = Modifier
                .background(Color.DarkGray)
        ){
            Text(
                text = "Add Screen",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xffffffff)
            )
        }
    }
}

