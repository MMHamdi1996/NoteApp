package com.example.noteapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.noteapp.databinding.RecyclerLayoutBinding


class MyAdapter(var context: Context, var itemList: MutableList<DataClass>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: RecyclerLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MyViewHolder(RecyclerLayoutBinding.inflate(LayoutInflater.from(context), parent, false))


override fun getItemCount(): Int {
    return itemList.size
}

override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
    holder.binding.title.text = itemList[position].itemListDataClass
}
}