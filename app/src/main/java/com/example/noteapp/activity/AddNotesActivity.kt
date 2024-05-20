package com.example.noteapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.noteapp.R
import com.example.noteapp.database.NotesDao
import com.example.noteapp.database.NotesData
import com.example.noteapp.database.NotesDataBase
import com.example.noteapp.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var notesDao: NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        val  notesDao = NotesDataBase.dataBaseBuilder(this).getNotesDao()

        binding.saveButton.setOnClickListener {
            val title = binding.titleNotesText.text.toString()
            val description = binding.desEditText.toString()

            val notesData = NotesData(title = title , description = description)
            notesDao.insertNotes(notesData)

        }
    }
}