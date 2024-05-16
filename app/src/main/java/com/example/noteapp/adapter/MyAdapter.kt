package com.example.noteapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.noteapp.database.NotesData
import com.example.noteapp.databinding.RecyclerLayoutBinding


class MyAdapter(var context: Context, var itemList: MutableList<NotesData>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RecyclerLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(context), parent, false))


override fun getItemCount(): Int {
    return itemList.size
}

override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.binding.title.text = itemList[position].title
    holder.binding.title.text = itemList[position].description
}
}