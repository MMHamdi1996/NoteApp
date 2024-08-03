package com.example.noteapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.model.NotesRepository

class NotesViewModelFactory(val repository: NotesRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NotesViewModel::class.java)) {
            return NotesViewModel(repository) as T // افزودن return برای برگرداندن نمونه
        }
        throw IllegalArgumentException("ViewModel Not Found")
    }
}
