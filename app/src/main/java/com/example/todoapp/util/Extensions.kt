package com.example.todoapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.todoapp.R

// AnasayfaFragment için navigation
fun Navigation.gecisYap(it:View,id:Int){
  findNavController(it).navigate(id)
}

// adapter için navigation
fun Navigation.gecisYap(it:View,id:NavDirections){
  findNavController(it).navigate(id)
}