package com.example.noteapp.view.trashcanadapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.RecyclerviewRowBinding
import com.example.noteapp.view.room.Note


class TrashCanAdapter(val deleteArrayList: ArrayList<Note>): RecyclerView.Adapter<TrashCanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrashCanViewHolder {
        val binding= RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TrashCanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return deleteArrayList.size
    }

    override fun onBindViewHolder(holder: TrashCanViewHolder, position: Int) {
        holder.binding.textViewNote.text= deleteArrayList[position].noteDescription
        holder.binding.textViewTitle.text= deleteArrayList[position].noteTitle
    }
}