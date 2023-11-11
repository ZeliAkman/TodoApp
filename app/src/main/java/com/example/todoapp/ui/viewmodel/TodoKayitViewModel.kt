package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.TodoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@HiltViewModel
class TodoKayitViewModel( var trepo: TodoRepository):ViewModel() {


     fun kaydet( todo_baslik : String, todo_aciklama :String){

          CoroutineScope(Dispatchers.Main).launch {
               trepo.kaydet(todo_baslik,todo_aciklama)
          }

     }
}

// arayuze daha yakın oldugu ıcın suspend kullanmadık ama suspend olmadıgında calısmadıgı ıcın CoroutıneScopeyı kullanıyoruz