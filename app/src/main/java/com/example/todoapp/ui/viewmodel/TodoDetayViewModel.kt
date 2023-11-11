package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoDetayViewModel@Inject constructor (var trepo:TodoRepository):ViewModel() {


    fun guncelle( todo_id :Int, todo_baslik : String, todo_aciklama :String){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.guncelle(todo_id,todo_baslik,todo_aciklama)
        }
    }
}

