package com.example.testnavigate.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testnavigate.room.note.Note
import com.example.testnavigate.room.note.NoteRepository
import com.example.testnavigate.room.note.NoteRoomDatabase
import com.example.testnavigate.room.product.Product
import com.example.testnavigate.room.product.ProductRepository
import com.example.testnavigate.room.product.ProductRoomDatabase

class NoteViewModel(application: Application) {

    private val repository: NoteRepository

    init {
        val noteDb = NoteRoomDatabase.getInstance(application)
        val noteDao = noteDb.noteDao()
        repository = NoteRepository(noteDao)

    }

    fun insertNote(newNote: Note) {
        repository.insertNote(newNote)
    }

}