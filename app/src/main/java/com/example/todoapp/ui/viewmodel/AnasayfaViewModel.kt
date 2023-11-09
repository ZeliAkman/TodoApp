package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.data.repo.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel:ViewModel() {

    var trepo = TodoRepository()
    var todoList = MutableLiveData<List<Todo>>()
    // ilk çalışacak fonks- önce veriler yüklensin
    init {
        todoYukle()
    }
    fun sil(todo_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.sil(todo_id)
        }
    }

    fun todoYukle() {
        CoroutineScope(Dispatchers.Main).launch {
           todoList.value= trepo.todoYukle()
        }
    }
}