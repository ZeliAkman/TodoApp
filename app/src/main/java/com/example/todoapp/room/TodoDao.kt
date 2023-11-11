package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.Todo

@Dao
interface TodoDao {

    @Query("SELECT*FROM todo")
    suspend fun todoYukle() : List<Todo>

    @Insert
    suspend fun kaydet(todo: Todo)

    @Update
    suspend fun guncelle(todo: Todo)
    //kişidetayfraagment-detayviewModel-kisilerrepostory-datasource

    @Delete
    suspend fun sil(todo: Todo)
    // kisilerda0 -datasource-

    @Query("SELECT * FROM todo WHERE todo_baslik like '%' || :aramaKelimesi || '%'")
    suspend fun ara(aramaKelimesi:String) : List<Todo>
}

// veritabanı üzerindeki fonksiyonları çalıştırdığımız yer
// arama yazma sılme ekleme ve günceleme işlemlerini yazıyoruz
// once Todoclassımız ,sonra buraası sonrada veritabanı kısmı halolucak

