package com.example.noteapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.database.NotesData
import com.example.noteapp.adapter.MyAdapter
import com.example.noteapp.database.NotesDao
import com.example.noteapp.database.NotesDataBase
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var notesDao: NotesDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)


        notesDao = NotesDataBase.dataBaseBuilder(this).getNotesDao()

        val adapter = MyAdapter(this, notesDao.getAllNOtes())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this , AddNotesActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}