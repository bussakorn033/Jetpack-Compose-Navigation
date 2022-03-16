package com.example.testnavigate.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ModalMessage(openModal: Boolean, closeModal: () -> Unit) {

    if (openModal) {

        AlertDialog(
//                modifier = Modifier.,
            onDismissRequest = {
                closeModal()
            },
            title = {
                Text(
                    text = "Title",
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                )
            },
            text = {
                Text(
                    text = "Here is a text",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Medium,
                )
            },
            confirmButton = {
                Button(
                    shape = RoundedCornerShape(10.dp),
                    colors = buttonColors(
                        backgroundColor = Color(0xffffc0cb),
                        contentColor = Color(0xff000000),
                        disabledBackgroundColor = Color(0xFFEBEBEB),
                        disabledContentColor = Color(0xFF949494),
                    ),
                    onClick = {
                        closeModal()
                    }) {
                    Text("Confirm")
                }
            },
            dismissButton = {
                Button(
                    shape = RoundedCornerShape(10.dp),
                    colors = buttonColors(
                        backgroundColor = Color(0xffffc0cb),
                        contentColor = Color(0xff000000),
                        disabledBackgroundColor = Color(0xFFEBEBEB),
                        disabledContentColor = Color(0xFF949494),
                    ),
                    onClick = {
                        closeModal()
                    }) {
                    Text("Dismiss")
                }
            },
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xff000000),
            contentColor = Color(0xffffc0cb),
//            properties = DialogProperties(
//                dismissOnBackPress = true,
//                dismissOnClickOutside = true,
//            ),
        )
    }
}