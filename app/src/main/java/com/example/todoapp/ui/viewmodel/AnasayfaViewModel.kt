package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.data.repo.TodoRepository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor (var trepo:TodoRepository):ViewModel() {
    var todoList = MutableLiveData<List<Todo>>()
    // ilk çalışacak fonks
    init {
        todoYukle()
    }
    fun sil(todo_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            trepo.sil(todo_id)
            todoYukle() // after delete ,update list
        }
    }

    fun todoYukle() {
        CoroutineScope(Dispatchers.Main).launch {
           todoList.value= trepo.todoYukle()
        }
    }

    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            todoList.value = trepo.ara(aramaKelimesi)
        }
    }
}