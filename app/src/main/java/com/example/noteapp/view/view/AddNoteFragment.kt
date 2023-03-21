package com.example.noteapp.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.findNavController
import com.example.noteapp.databinding.FragmentAddNoteBinding
import com.example.noteapp.view.adapter.RecyclerViewAdapter
import com.example.noteapp.view.room.Note
import com.example.noteapp.view.room.NoteDAO
import com.example.noteapp.view.room.NoteDB


class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddNoteBinding? = null
    private val binding get() = _binding!!

    private lateinit var noteDao: NoteDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        val view = binding.root


        val noteDb = NoteDB.getInstance(requireContext())
        noteDao= noteDb.noteDao

        setFragmentResultListener("noteInformation"){requestKey, bundle ->

            _binding!!.editTextNote.setText(bundle.getString("note"))
            _binding!!.editTextTitle.setText(bundle.getString("title"))
            val fromWhere= bundle.getString("where")
            val noteId= bundle.getInt("id")


            when(fromWhere){

                "HomeFragment" -> _binding!!.fabSave.setOnClickListener {

                    noteDao.insert(
                        Note(
                            0,
                            noteTitle = _binding!!.editTextTitle.text.toString(),
                            noteDescription = _binding!!.editTextNote.text.toString()
                        )
                    )

                    val action= AddNoteFragmentDirections.actionAddNoteFragmentToHomeFragment()
                    view.findNavController().navigate(action)
                }

                "Adapter" -> _binding!!.fabSave.setOnClickListener {
                    noteDao.update(
                        Note(
                            noteId,
                            noteTitle = _binding!!.editTextTitle.text.toString(),
                            noteDescription = _binding!!.editTextNote.text.toString()
                        )
                    )

                    val action= AddNoteFragmentDirections.actionAddNoteFragmentToHomeFragment()
                    view.findNavController().navigate(action)
                }

            }

        }

        return view
    }


}