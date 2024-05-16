package com.example.noteapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.database.NotesData
import com.example.noteapp.adapter.MyAdapter
import com.example.noteapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        var itemList = mutableListOf<NotesData>()
        itemList.add(NotesData("a" , "1"))
        itemList.add(NotesData("b" , "3"))

        val adapter = MyAdapter(this, itemList)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.addButton.setOnClickListener{
            val intent = Intent(this , AddNotesActivity::class.java)
            startActivity(intent)
        }


        val getIntent = intent
        val value = intent.getStringExtra("message")
        Toast.makeText(this, value, Toast.LENGTH_SHORT).show()
    }
}