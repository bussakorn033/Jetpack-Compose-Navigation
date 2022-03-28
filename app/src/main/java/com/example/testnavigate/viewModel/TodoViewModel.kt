package com.example.testnavigate.viewModel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnavigate.api.APIService
import com.example.testnavigate.api.Todo
import kotlinx.coroutines.launch


class TodoViewModel : ViewModel() {
    var errorMessage: String by mutableStateOf("")
    var test: String by mutableStateOf("")

    /* Todo List */
    private val _todoList = mutableStateListOf<Todo>()
    val todoList: List<Todo>
        get() = _todoList

    fun getTodoList() {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {
                _todoList.clear()
                _todoList.addAll(apiService.getTodos())
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
    /* Todo List */


    /* Todo Id */
    private var _todoItem: Todo? by mutableStateOf<Todo?>(null)
    val todoItem: Todo?
        get() = _todoItem

    fun getIdTodo(Id: Int) {
        viewModelScope.launch {
            val apiService = APIService.getInstance()
            try {

                _todoItem = apiService.getIdTodo(Id)
            } catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
    /* Todo Id */

}