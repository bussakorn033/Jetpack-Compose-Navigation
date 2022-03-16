package com.example.testnavigate.screens.home.children

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testnavigate.components.ModalMessage

@Composable
fun ChildrenHomeScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(Color.Blue.copy(0.4f))
            .fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier
                .background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Children Home Screen",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xffffffff)
            )

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Pop Back Stack")
            }

        }
    }
}