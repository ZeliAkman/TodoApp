package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoKayitBinding
import com.example.todoapp.ui.viewmodel.TodoKayitViewModel


class TodoKayitFragment : Fragment() {
    private lateinit var binding: FragmentTodoKayitBinding
    private lateinit var viewModel: TodoKayitViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_todo_kayit, container, false)

        binding.todoKayitFragment=this
        return binding.root
    }

    // viewModel kurulumu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:TodoKayitViewModel by viewModels()
        viewModel=tempViewModel
    }

    fun buttonKaydet( todo_baslik : String, todo_aciklama :String){
        viewModel.kaydet(todo_baslik,todo_aciklama)
    }


}