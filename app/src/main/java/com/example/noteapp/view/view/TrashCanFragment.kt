package com.example.noteapp.view.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.noteapp.databinding.FragmentTrashCanBinding


class TrashCanFragment : Fragment() {

    private var _binding: FragmentTrashCanBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTrashCanBinding.inflate(inflater, container, false)
        val view = binding.root
        println("FragmentTrashCanBinding fragment")
        return view
    }


}