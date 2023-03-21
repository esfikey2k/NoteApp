package com.example.noteapp.view.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.databinding.RecyclerviewRowBinding
import com.example.noteapp.view.room.Note
import com.example.noteapp.view.view.HomeFragment
import com.example.noteapp.view.view.HomeFragmentDirections


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

        holder.itemView.setOnClickListener {

            holder.itemView.findFragment<HomeFragment>().setFragmentResult("noteInformation",
                bundleOf(
                    "note" to noteArrayList[position].noteDescription,
                    "title" to noteArrayList[position].noteTitle,
                    "id" to noteArrayList[position].noteId,
                    "where" to "Adapter"
                )
            )

//            holder.itemView.findFragment<HomeFragment>().setFragmentResult("fromWhere",
//                bundleOf(
//                    "where" to "Adapter"
//                )
//            )

            val action= HomeFragmentDirections.actionHomeFragmentToAddNoteFragment()
            holder.itemView.findNavController().navigate(action)

        }

    }
}

