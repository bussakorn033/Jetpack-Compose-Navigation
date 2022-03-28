package com.example.testnavigate.screens.detail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.testnavigate.viewModel.TodoViewModel

@Composable
fun DetailScreen(navController: NavHostController, userId: String?) {
    val vm = TodoViewModel()
    vm.getTodoList()

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
            ) {
                itemsIndexed(vm.todoList) { index, todo ->
                    val context = LocalContext.current
                    Column() {
                        TextButton(
                            onClick = {
                                /*TODO*/
                                navController.navigate("children_detail_screen/${todo.id}") {
                                    popUpTo("detail_screen") { saveState = true }
                                }
                                Toast.makeText(
                                    context,
                                    "${todo}",
                                    Toast.LENGTH_LONG
                                )
                                    .show()
                            }
                        ) {
                            Column {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth(0.8f)
                                    ) {
                                        Text(
                                            "${index + 1}. ID:${todo.id} ${todo.title}",
                                            maxLines = 1,
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
                            }
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

