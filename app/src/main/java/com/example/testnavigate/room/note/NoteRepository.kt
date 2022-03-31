package com.example.testnavigate.room.note

import com.example.testnavigate.room.product.Product
import com.example.testnavigate.room.product.ProductDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteRepository(private val noteDao: NoteDao) {

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun insertNote(newNote: Note) {
        coroutineScope.launch(Dispatchers.IO) {
            noteDao.insertNote(newNote)
        }
    }
}