package com.example.testnavigate.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun ProductRow(
    id: Int,
    name: String,
    quantity: Int,
    navController: NavHostController,
    isButton: Boolean = true,
) {
    TextButton(
        colors = ButtonDefaults.textButtonColors(
            disabledContentColor = Color.Black
        ),
        enabled = isButton,
        onClick = {
            if (isButton) {
                navController.navigate(route = "room_live_data_item/${id}") {
                    popUpTo("room_live_data") {
                        saveState = true
                    }
                }
            }
        }
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
        ) {
            Text(
                id.toString(), modifier = Modifier
                    .weight(0.1f)
            )
            Text(name, modifier = Modifier.weight(0.2f))
            Text(quantity.toString(), modifier = Modifier.weight(0.2f))
        }
    }
}
