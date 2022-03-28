package com.example.testnavigate.screens.childrenDetail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material.icons.filled.HighlightOff
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.testnavigate.viewModel.TodoViewModel


@Composable
fun ChildrenDetailScreen(navController: NavHostController, userId: String?, vm: TodoViewModel) {
//    val vm = TodoViewModel()
    vm.getIdTodo(Integer.parseInt(userId))

    LaunchedEffect(Unit, block = {
        vm.getIdTodo(Integer.parseInt(userId))
        println("vm.todoItem:${vm.todoItem}")
    })

    if (vm.errorMessage.isEmpty()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "${vm.todoItem?.id}. Title: ${vm.todoItem?.title}",
                color = Color.Black,
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
            )

            Spacer(modifier = Modifier.height(5.dp))

            if (vm.todoItem?.completed == true) {
                Icon(
                    Icons.Filled.CheckCircleOutline,
                    contentDescription = "Yes",
                    tint = Color.Green,
                    modifier = Modifier
                        .size(100.dp)
                )
            } else {
                Icon(
                    Icons.Filled.HighlightOff,
                    contentDescription = "No",
                    tint = Color.Red,
                    modifier = Modifier
                        .size(100.dp)
                )
            }

            Spacer(modifier = Modifier.height(5.dp))

            Button(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Text("Pop Back Stack")
            }

        }
    } else {
        Text(vm.errorMessage)
    }

}

