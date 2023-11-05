package com.example.todoapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todoapp.R
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.databinding.FragmentAnasayfaBinding
import com.example.todoapp.ui.adapter.TodoAdapter

@Suppress("UNREACHABLE_CODE")
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding=FragmentAnasayfaBinding.inflate(inflater, container, false)

        // rv setting
        binding.rv.layoutManager =LinearLayoutManager(requireContext())

        val todoList = ArrayList<Todo>()
        val t1 = Todo(1,"Ders Çalış","Hergün 8 Saat Yazılım Çalış ")
        val t2 = Todo(2,"Kitap Okuma ","Kitap okuma saatlerini kaçırma")
        val t3 = Todo(3,"Toplantı ","Kız kıza Toplantı ")
        val t4 = Todo(4,"Buluşma","İlerleme takibi ")
        val t5 = Todo(5,"Yürüyüş ","Kitap okuma saatlerini kaçırma")
        val t6 = Todo(6,"Alışveriş ","Kız kıza Toplantı ")
        todoList.add(t1)
        todoList.add(t2)
        todoList.add(t3)
        todoList.add(t4)
        todoList.add(t5)
        todoList.add(t6)

        val todoAdapter = TodoAdapter(requireContext(),todoList)
        binding.rv.adapter=todoAdapter


        // fab button action
        binding.fab.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.todoKayitFragment)
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

    fun ara(aramaKelimesi:String){
        Log.e("ToDo  Ara : ",aramaKelimesi)

    }


}
