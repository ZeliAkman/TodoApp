package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentTodoDetayBinding
import com.example.todoapp.ui.viewmodel.TodoDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoDetayFragment : Fragment() {
    private lateinit var binding: FragmentTodoDetayBinding
    private lateinit var viewModel: TodoDetayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_todo_detay, container, false)
        binding.todoDetayFragment=this

        val bundle:TodoDetayFragmentArgs by navArgs()
        val gelenTodo = bundle.todo
        binding.todoNesnesi=gelenTodo


        return binding.root
    }

    // viewModel kurulumu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : TodoDetayViewModel by viewModels()
        viewModel = tempViewModel

    }

    fun buttonGuncelle( todo_id :Int, todo_baslik : String, todo_aciklama :String){
        viewModel.guncelle(todo_id,todo_baslik,todo_aciklama)
    }


}