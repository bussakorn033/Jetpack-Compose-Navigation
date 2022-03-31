package com.example.testnavigate.room.note

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
class Note {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "Id")
    var id: Int = 0

    @ColumnInfo(name = "noteId")
    var noteId: Int = 0

    @ColumnInfo(name = "noteTitle")
    var noteTitle: String = ""

    @ColumnInfo(name = "noteComplete")
    var noteComplete: Boolean = false

    constructor() {}

    constructor(
        id: Int,
        noteId: Int,
        noteTitle: String,
        noteComplete: Boolean
    ) {
        this.id = id
        this.noteId = noteId
        this.noteTitle = noteTitle
        this.noteComplete = noteComplete
    }

    constructor(
        noteId: Int,
        noteTitle: String,
        noteComplete: Boolean
    ) {
        this.noteId = noteId
        this.noteTitle = noteTitle
        this.noteComplete = noteComplete
    }

}