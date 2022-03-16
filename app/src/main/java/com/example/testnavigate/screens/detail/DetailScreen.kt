package com.example.testnavigate.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Button
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testnavigate.api.TodoViewModel

@Composable
fun DetailScreen(navController: NavHostController, userId: String?) {
    val vm = TodoViewModel()

    LaunchedEffect(Unit, block = {
        vm.getTodoList()
    })

    if (vm.errorMessage.isEmpty()) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xffffc0cb).copy(1f)),
            ) {

                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "API userID : $userId",
                    fontWeight = FontWeight.Medium
                )
            }

            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(horizontal = 16.dp),
            ) {
                items(vm.todoList) { todo ->
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 8.dp, vertical = 16.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .padding(0.dp, 0.dp, 0.dp, 0.dp)
                            ) {
                                Text(
                                    "${todo.id}. ${todo.title}",
//                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis
                                )
                            }

                            Spacer(modifier = Modifier.width(16.dp))

                            Checkbox(
                                modifier = Modifier
                                    .fillMaxWidth(0.2f),
                                checked = todo.completed,
                                onCheckedChange = null
                            )
                        }
                        Divider()
                    }
                }
            }
        }
    } else {
        Text(vm.errorMessage)
    }
}

