package com.example.noteapp.model

import androidx.lifecycle.LiveData

class NotesRepository(val dao: NotesDao) {
    fun insertNotes(notesData: NotesData) {
        dao.insertNotes(notesData)
    }

    fun deleteNotes(notesData: NotesData) {
        dao.deleteNotes(notesData)
    }

    fun getAllNotes(){
        dao.getAllNOtes()
    }

}