package com.example.noteapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.example.noteapp.R
import com.example.noteapp.database.NotesDao
import com.example.noteapp.database.NotesData
import com.example.noteapp.database.NotesDataBase
import com.example.noteapp.databinding.ActivityAddNotesBinding

class AddNotesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var notesDao: NotesDao
    private var showNotes : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        notesDao = NotesDataBase.dataBaseBuilder(this).getNotesDao()

        var intent : Intent = intent
        showNotes = intent.getBooleanExtra("showNotes" , false)
        val position = intent.getIntExtra("position" , 0)

        if (showNotes){
            binding.addNotesActivityTitleView.text = "نمایش یادداشت"
            binding.saveButton.visibility = View.GONE
            binding.titleNotesText.isEnabled = false
            binding.desEditText.isEnabled = false
            binding.titleNotesText.setText(notesDao.getAllNOtes()[position].title)
            binding.desEditText.setText(notesDao.getAllNOtes()[position].description)
        }


        binding.saveButton.setOnClickListener {
            val title = binding.titleNotesText.text.toString()
            val description = binding.desEditText.text.toString()
            val notesData = NotesData(title = title , description = description)
            notesDao.insertNotes(notesData)
            val intent = Intent(this , MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}