package com.example.noteapp.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import android.widget.PopupMenu
//import androidx.fragment.app.setFragmentResultListener
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.example.noteapp.R

import com.example.noteapp.databinding.FragmentTrashCanBinding
//import com.example.noteapp.view.adapter.RecyclerViewAdapter
//import com.example.noteapp.view.room.Note
//import com.example.noteapp.view.room.NoteDAO
//import com.example.noteapp.view.room.NoteDB
//import com.example.noteapp.view.trashcanadapter.TrashCanAdapter


class TrashCanFragment : Fragment() {

    private var _binding: FragmentTrashCanBinding? = null
    private val binding get() = _binding!!

//    private lateinit var noteDao: NoteDAO
//    private lateinit var noteDeleteArrayList: ArrayList<Note>
//    private lateinit var noteStringArrayList: ArrayList<String>
//    private lateinit var titleStringArrayList: ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrashCanBinding.inflate(inflater, container, false)
        val view = binding.root

//        val noteDb = NoteDB.getInstance(requireContext())
//        noteDao= noteDb.noteDao


//        setFragmentResultListener("noteInformation"){requestKey, bundle ->
//
//            val noteFromDelete= bundle.getString("note")
//            val titleFromDelete= bundle.getString("title")
//            val idFromDelete= bundle.getInt("id")
//
//            println("Trash can noteFromDelete ${noteFromDelete.toString()}")
//            println("Trash can titleFromDelete ${titleFromDelete.toString()}")
//            println("Trash can id $idFromDelete")
//
//            noteDeleteArrayList= noteDao.getById(idFromDelete) as ArrayList<Note>
//
//            noteDeleteArrayList.add(Note(
//                idFromDelete,
//                noteTitle = titleFromDelete.toString(),
//                noteDescription = noteFromDelete.toString()
//            ))
//
//            println("notedelete ${noteDeleteArrayList.toString()}")
//
//            _binding!!.recyclerViewTrashCan.layoutManager= LinearLayoutManager(requireContext())
//            val noteAdapter= TrashCanAdapter(noteDeleteArrayList)
//            _binding!!.recyclerViewTrashCan.adapter= noteAdapter
//
//
//        }

        return view
    }


}