package com.example.todoapp.data.entity

import java.io.Serializable

data class Todo(var todo_id : Int , var todo_baslik : String, var todo_aciklama :String) : Serializable {
}