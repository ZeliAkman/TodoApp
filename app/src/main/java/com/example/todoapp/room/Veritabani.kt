package com.example.todoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.todoapp.data.entity.Todo

@Database(entities = [Todo::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    abstract fun getTodoDao() : TodoDao
}



// her tabloya bir class