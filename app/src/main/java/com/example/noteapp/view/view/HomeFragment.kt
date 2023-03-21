package com.example.noteapp.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.noteapp.databinding.FragmentHomeBinding
import com.example.noteapp.view.adapter.RecyclerViewAdapter
import com.example.noteapp.view.room.Note
import com.example.noteapp.view.room.NoteDAO
import com.example.noteapp.view.room.NoteDB


class HomeFragment : Fragment() {


    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var noteDao: NoteDAO
    private lateinit var noteArrayList: ArrayList<Note>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        _binding!!.fab.setOnClickListener {

            setFragmentResult("noteInformation", bundleOf("where" to "HomeFragment"))
            val action= HomeFragmentDirections.actionHomeFragmentToAddNoteFragment()
            view.findNavController().navigate(action)
        }

        val noteDb = NoteDB.getInstance(requireContext())
        noteDao= noteDb.noteDao

        noteArrayList= noteDao.getAll() as ArrayList<Note>

        _binding!!.recyclerView.layoutManager= LinearLayoutManager(requireContext())
        val noteAdapter= RecyclerViewAdapter(noteArrayList)
        _binding!!.recyclerView.adapter= noteAdapter



        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}