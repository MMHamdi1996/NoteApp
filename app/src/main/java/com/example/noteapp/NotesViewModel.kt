package com.example.noteapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.noteapp.model.NotesDao
import com.example.noteapp.model.NotesData
import com.example.noteapp.model.NotesRepository

class NotesViewModel(val repository: NotesRepository) : ViewModel() {
    val title = MutableLiveData<String>()
    val description = MutableLiveData<String>()
    val saveClick = MutableLiveData<Boolean>()

    init {
        saveClick.value = false
    }

    fun addNotesToDatabase() {
        saveClick.value = true
        val notes = NotesData(
            title = title.value!!,
            description = description.value!!
        )
        repository.insertNotes(notes)
    }
}