package com.example.noteapp.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noteapp.databinding.FragmentTrashCanBinding
import com.example.noteapp.view.room.NoteDAO
import com.example.noteapp.view.room.NoteDB
import com.example.noteapp.view.trashcanadapter.TrashCanAdapter
import com.example.noteapp.view.room.DeletedNote


class TrashCanFragment : Fragment() {

    private var _binding: FragmentTrashCanBinding? = null
    private val binding get() = _binding!!

    private lateinit var noteDao: NoteDAO
    private lateinit var noteDeletedArrayList: ArrayList<DeletedNote>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrashCanBinding.inflate(inflater, container, false)
        val view = binding.root

        val noteDb = NoteDB.getInstance(requireContext())
        noteDao= noteDb.noteDao

        noteDeletedArrayList= noteDao.getAllDeleted() as ArrayList<DeletedNote>

        _binding!!.recyclerViewTrashCan.layoutManager= LinearLayoutManager(requireContext())
        val noteAdapter= TrashCanAdapter(noteDeletedArrayList)
        _binding!!.recyclerViewTrashCan.adapter= noteAdapter


        return view
    }




}