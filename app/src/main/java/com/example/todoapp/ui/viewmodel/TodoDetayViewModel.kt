package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.repo.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoDetayViewModel:ViewModel() {

    var trepo = TodoRepository()
    fun guncelle( todo_id :Int, todo_baslik : String, todo_aciklama :String){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.guncelle(todo_id,todo_baslik,todo_aciklama)
        }
    }
}

