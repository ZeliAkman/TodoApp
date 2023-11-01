package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoKayitBinding


class TodoKayitFragment : Fragment() {
    private lateinit var binding: FragmentTodoKayitBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = FragmentTodoKayitBinding.inflate(inflater, container, false)
        return binding.root
    }


}