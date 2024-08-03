package com.example.noteapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.NotesViewModel
import com.example.noteapp.NotesViewModelFactory
import com.example.noteapp.R
import com.example.noteapp.adapter.MyAdapter
import com.example.noteapp.model.NotesDao
import com.example.noteapp.model.NotesDataBase
import com.example.noteapp.databinding.ActivityMainBinding
import com.example.noteapp.model.NotesRepository

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var notesDao: NotesDao
    private lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main) // مقداردهی دیتا بایندینگ
        notesDao = NotesDataBase.dataBaseBuilder(this).getNotesDao() // مقداردهی دیتابیس و DAO

        // مقداردهی ViewModel
        val repository = NotesRepository(notesDao)
        notesViewModel = ViewModelProvider(this, NotesViewModelFactory(repository))[NotesViewModel::class.java]
        binding.notesData = notesViewModel // اتصال ViewModel به دیتا بایندینگ

        // تنظیم RecyclerView و Adapter
        val adapter = MyAdapter(this, notesDao.getAllNOtes())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // تنظیم دکمه اضافه کردن یادداشت
        binding.addButton.setOnClickListener {
            binding.mainConstraintLayout.visibility = View.INVISIBLE
            binding.addNotesConstraintLayout.visibility = View.VISIBLE
        }

        // مشاهده تغییرات در LiveData و به‌روزرسانی UI
        notesViewModel.saveClick.observe(this) {
            if (it) {
                adapter.notifyDataSetChanged()
                binding.mainConstraintLayout.visibility = View.VISIBLE
                binding.addNotesConstraintLayout.visibility = View.INVISIBLE
                notesViewModel.saveClick.value = false // بازنشانی مقدار برای جلوگیری از تکرار
            }
        }
    }
}
