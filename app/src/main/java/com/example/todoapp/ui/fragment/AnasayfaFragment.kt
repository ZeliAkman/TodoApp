package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.databinding.FragmentAnasayfaBinding
import com.example.todoapp.ui.adapter.TodoAdapter
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel


class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa, container, false)
        binding.anasayfaFragment=this

        viewModel.todoList.observe(viewLifecycleOwner){
            val todoAdapter = TodoAdapter(requireContext(),it,viewModel)
            binding.todoAdapter=todoAdapter

        }







        //Searchview Fonks.
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }
        })
        return binding.root
    }

    // viewModel kurulumu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temptViewModel:AnasayfaViewModel by viewModels()
        viewModel=temptViewModel
    }

    fun fabTikla(it:View){
        Navigation.findNavController(it).navigate(R.id.todoKayitGecis)
    }

    fun ara(aramaKelimesi:String){
        Log.e("ToDo  Ara : ",aramaKelimesi)

    }

}
