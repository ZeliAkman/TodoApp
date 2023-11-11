package com.example.todoapp.data.datasource

import android.util.Log
import com.example.todoapp.data.entity.Todo
import com.example.todoapp.room.TodoDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource(var tdao: TodoDao) {

    suspend fun todoYukle() : List<Todo> =
        withContext(Dispatchers.IO) {
        return@withContext tdao.todoYukle()
    }


   suspend fun ara(aramaKelimesi:String) : List<Todo> =
       withContext(Dispatchers.IO) {
       val todoList = ArrayList<Todo>()
       val t1 = Todo(1, "Ders Çalış", "Hergün 8 Saat Yazılım Çalış")
       todoList.add(t1)
       return@withContext todoList
   }


    suspend fun kaydet( todo_baslik : String, todo_aciklama :String){
        Log.e("To Do Kaydet : " , " $todo_baslik - $todo_aciklama")
    }

    suspend fun guncelle( todo_id :Int, todo_baslik : String, todo_aciklama :String){
        Log.e("To Do Günceleme  : " , "$todo_id - $todo_baslik - $todo_aciklama")
    }

     suspend fun sil(todo_id:Int){
        Log.e(" To Do Kişi sil ",todo_id.toString())
    }
}
// fragment sayfasından fun alınıp başına suspend eklendi.
// suspend ten ıtıbaren fonk ismi kopyalanıp repo kısmına kaydedicez