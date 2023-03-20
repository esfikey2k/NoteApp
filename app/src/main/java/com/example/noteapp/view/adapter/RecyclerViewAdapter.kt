package com.example.noteapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.RecyclerviewRowBinding
import com.example.noteapp.view.room.Note


class RecyclerViewAdapter(val noteArrayList: ArrayList<Note>): RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding= RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return noteArrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.textViewNote.text= noteArrayList[position].noteDescription
        holder.binding.textViewTitle.text= noteArrayList[position].noteTitle

    }
}