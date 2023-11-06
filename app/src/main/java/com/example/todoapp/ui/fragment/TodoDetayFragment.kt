package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoDetayBinding


class TodoDetayFragment : Fragment() {
    private lateinit var binding: FragmentTodoDetayBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentTodoDetayBinding.inflate(inflater, container, false)

        val bundle:TodoDetayFragmentArgs by navArgs()
        val gelenTodo = bundle.todo

        binding.editBaslik.setText(gelenTodo.todo_baslik)
        binding.editAciklama.setText(gelenTodo.todo_aciklama)

        binding.buttonUpdate.setOnClickListener {
            val todo_baslik= binding.editBaslik.text.toString()
            val todo_aciklama= binding.editAciklama.text.toString()
            guncelle(gelenTodo.todo_id,todo_baslik,todo_aciklama)
        }

        return binding.root
    }

    fun guncelle( todo_id :Int, todo_baslik : String, todo_aciklama :String){
        Log.e("To Do : " , "$todo_id- $todo_baslik - $todo_aciklama")
    }


}