package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.TodoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoKayitViewModel:ViewModel() {

     var trepo = TodoRepository()
     fun kaydet( todo_baslik : String, todo_aciklama :String){

          CoroutineScope(Dispatchers.Main).launch {
               trepo.kaydet(todo_baslik,todo_aciklama)
          }

     }
}

// arayuze daha yakın oldugu ıcın suspend kullanmadık ama suspendsizde calısmadıgı ıcın CoroutıneScopeyı kullanıyoruz