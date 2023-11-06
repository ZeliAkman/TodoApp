package com.example.todoapp.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.databinding.CardTasarimiBinding
import com.example.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.google.android.material.snackbar.Snackbar

class TodoAdapter(var mContext : Context,var  todoList :List<Todo> ) : RecyclerView.Adapter<TodoAdapter.CardTasarimTutucu>(){

    inner class CardTasarimTutucu( var tasarim: CardTasarimiBinding) :RecyclerView.ViewHolder(tasarim.root)

    // Binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimiBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }

    // Actions
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val todo = todoList.get(position)
        val t = holder.tasarim

        t.textCardBaslik.text = todo.todo_baslik
        t.textCardAciklama.text=todo.todo_aciklama

        t.cardViewSatir.setOnClickListener{
            // seçilen karta geçiş
            val gecis = AnasayfaFragmentDirections.todoDetayGecis(todo = todo)
            Navigation.findNavController(it).navigate(gecis)

        }
        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${todo.todo_baslik} silinsin mi ? ",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    sil(todo.todo_id)
                }.show()
        }
    }

    // size
    override fun getItemCount(): Int {

        return todoList.size
    }


    fun sil(todo_id:Int){
        Log.e("Kişi sil ",todo_id.toString())
    }

}