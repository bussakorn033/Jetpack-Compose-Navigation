package com.example.testnavigate.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.Navigator
import androidx.navigation.navArgument
import androidx.navigation.navOptions
import com.example.testnavigate.api.TodoViewModel
import com.example.testnavigate.components.ModalMessage

@Composable
fun HomeScreen(navController: NavHostController) {
    val (openModal, setOpenModal) = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(Color.Blue)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,

        ) {
        Column(
            modifier = Modifier
                .background(Color.DarkGray),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Home Screen",
                fontSize = 50.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color(0xffffffff)
            )
            Row(modifier = Modifier.padding(16.dp)) {

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        setOpenModal(true)
                    }
                ) {
                    Text("Modal")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        navController.navigate("children_home_screen")
                    }
                ) {
                    Text("Children")
                }

                Spacer(modifier = Modifier.width(10.dp))

                Button(
                    modifier = Modifier.weight(1f),
                    onClick = {
                        navController.navigate("detail_screen/UserId_1") {
                            popUpTo("home_screen") { inclusive = true }
                        }
                    }
                ) {
                    Text("Detail")
                }
            }
        }
    }
    ModalMessage(
        openModal = openModal,
        closeModal = { setOpenModal(false) }
    )
}
