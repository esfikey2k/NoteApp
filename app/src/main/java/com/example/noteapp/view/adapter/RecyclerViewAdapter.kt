package com.example.noteapp.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.os.bundleOf
import androidx.fragment.app.findFragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.databinding.RecyclerviewRowBinding
import com.example.noteapp.view.room.Note
import com.example.noteapp.view.room.NoteDAO
import com.example.noteapp.view.room.NoteDB
import com.example.noteapp.view.view.HomeFragment
import com.example.noteapp.view.view.HomeFragmentDirections


class RecyclerViewAdapter(val noteArrayList: ArrayList<Note>): RecyclerView.Adapter<ViewHolder>() {

    private lateinit var noteDao: NoteDAO

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

            val action= HomeFragmentDirections.actionHomeFragmentToAddNoteFragment()
            holder.itemView.findNavController().navigate(action)

        }

        holder.binding.recyclerCardView.setOnLongClickListener {

            val noteDb = NoteDB.getInstance(holder.itemView.context)
            noteDao= noteDb.noteDao
            val popupMenu: PopupMenu = PopupMenu(holder.itemView.context,holder.binding.recyclerCardView)
            popupMenu.menuInflater.inflate(R.menu.popup,popupMenu.menu)
            popupMenu.show()
            popupMenu.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->

                if (item.itemId == R.id.process_delete){
                    noteDao.delete(
                        Note(
                            noteArrayList[position].noteId,
                            noteDescription = noteArrayList[position].noteDescription,
                            noteTitle = noteArrayList[position].noteTitle
                        )
                    )
                    noteArrayList.removeAt(holder.adapterPosition)
                    notifyDataSetChanged()
                }
                true
            })
            true
        }

    }
}

