package com.example.todoapp.data.datasource

import android.util.Log
import com.example.todoapp.data.entity.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodoDataSource {

    suspend fun todoYukle() : List<Todo> = withContext(Dispatchers.IO) {
        val todoList = ArrayList<Todo>()
        val t1 = Todo(1, "Ders Çalış", "Hergün 8 Saat Yazılım Çalış")
        val t2 = Todo(2, "Kitap Okuma", "Kitap okuma saatlerini kaçırma")
        val t3 = Todo(3, "Toplantı", "Kız kıza Toplantı")
        val t4 = Todo(4, "Buluşma", "İlerleme takibi")
        val t5 = Todo(5, "Yürüyüş", "Doğa yürüyüşü")
        val t6 = Todo(6, "Alışveriş", "Alışveriş yapılacak")

        todoList.add(t1)
        todoList.add(t2)
        todoList.add(t3)
        todoList.add(t4)
        todoList.add(t5)
        todoList.add(t6)

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