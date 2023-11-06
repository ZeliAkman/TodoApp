package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
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

        binding.buttonSave.setOnClickListener {

            val todo_baslik = binding.editBaslik.text.toString()
            val todo_aciklama =binding.editAciklama.text.toString()
            kaydet(todo_baslik, todo_aciklama)
        }
        return binding.root
    }

    fun kaydet( todo_baslik : String, todo_aciklama :String){
        Log.e("To Do : " , " $todo_baslik - $todo_aciklama")
    }


}