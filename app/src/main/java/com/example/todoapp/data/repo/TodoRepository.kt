package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.TodoDataSource
import com.example.todoapp.data.entity.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class  TodoRepository(var tds:TodoDataSource) {
    suspend fun kaydet( todo_baslik : String, todo_aciklama :String) = tds.kaydet(todo_baslik,todo_aciklama)

    suspend fun guncelle( todo_id :Int, todo_baslik : String, todo_aciklama :String) = tds.guncelle(todo_id,todo_baslik,todo_aciklama)

    suspend fun sil(todo_id:Int) = tds.sil(todo_id)

    suspend fun todoYukle() : List<Todo> = tds.todoYukle()

    suspend fun ara(aramaKelimesi:String) : List<Todo> = tds.ara(aramaKelimesi)
}
// todoDataSourceden fun ismini kopyalayıp buraya yapıstrdk
// sonra viewmodele gidip fonk. buraya da ekliyoruz