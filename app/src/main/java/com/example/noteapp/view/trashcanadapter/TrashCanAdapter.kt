package com.example.noteapp.view.trashcanadapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.RecyclerviewRowBinding
import com.example.noteapp.view.room.DeletedNote


class TrashCanAdapter(val deleteArrayList: ArrayList<DeletedNote>): RecyclerView.Adapter<TrashCanViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrashCanViewHolder {
        val binding= RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return TrashCanViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return deleteArrayList.size
    }

    override fun onBindViewHolder(holder: TrashCanViewHolder, position: Int) {
        holder.binding.textViewNote.text= deleteArrayList[position].deletedNoteDescription
        holder.binding.textViewTitle.text= deleteArrayList[position].deletedNoteTitle
        holder.binding.textViewDate.text= deleteArrayList[position].deletedNoteDate

    }
}