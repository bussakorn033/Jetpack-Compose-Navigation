package com.example.testnavigate.room.note

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.testnavigate.room.product.Product

@Dao
interface NoteDao {

    @Insert
    fun insertNote(note: Note)

}