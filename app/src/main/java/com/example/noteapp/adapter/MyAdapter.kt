package com.example.noteapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.noteapp.activity.AddNotesActivity
import com.example.noteapp.database.NotesData
import com.example.noteapp.databinding.RecyclerLayoutBinding


class MyAdapter(var context: Context, var getAllNOtes: MutableList<NotesData>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RecyclerLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(context), parent, false))


override fun getItemCount(): Int {
    return getAllNOtes.size
}

override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.binding.title.text = getAllNOtes[position].title
    holder.binding.describtion.text = getAllNOtes[position].description

    holder.binding.recyclerLayoutLayaout.setOnClickListener{
        val intent = Intent(context ,AddNotesActivity::class.java )
        intent.putExtra("showNotes" , true )
        intent.putExtra("position" , position)
        context.startActivity(intent)
    }
}
}