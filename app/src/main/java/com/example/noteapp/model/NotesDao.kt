package com.example.noteapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NotesDao {
    @Query("Select * From Notes")
    fun getAllNOtes(): MutableList<NotesData>

    @Insert
    fun insertNotes(notesData: NotesData)

    @Delete
    fun deleteNotes(notesData: NotesData)
}