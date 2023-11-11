package com.example.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.databinding.CardTasarimiBinding
import com.example.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel
import com.example.todoapp.util.gecisYap
import com.google.android.material.R
import com.google.android.material.snackbar.Snackbar

class TodoAdapter(var mContext : Context,var  todoList :List<Todo> , var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<TodoAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu( var tasarim: CardTasarimiBinding) :RecyclerView.ViewHolder(tasarim.root)

    // Binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding :CardTasarimiBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext),com.example.todoapp.R.layout.card_tasarimi,parent,false)
        return CardTasarimTutucu(binding)
    }

    // Actions
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val todo = todoList.get(position)
        val t = holder.tasarim

        t.todoNesnesi = todo

        t.cardViewSatir.setOnClickListener{
            // seçilen karta geçiş
            val gecis = AnasayfaFragmentDirections.todoDetayGecis(todo = todo)
            Navigation.gecisYap(it,gecis) // Extensions

        }
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${todo.todo_baslik} silinsin mi ? ",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    viewModel.sil(todo.todo_id)
                }.show()
        }
    }

    // size
    override fun getItemCount(): Int {

        return todoList.size
    }



}