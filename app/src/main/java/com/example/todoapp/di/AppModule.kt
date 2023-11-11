package com.example.todoapp.di

import android.content.Context
import androidx.room.Room
import com.example.todoapp.data.datasource.TodoDataSource
import com.example.todoapp.data.repo.TodoRepository
import com.example.todoapp.room.TodoDao
import com.example.todoapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideTodoDataSource(tdao:TodoDao) : TodoDataSource{
        return TodoDataSource(tdao)
    }


    @Provides
    @Singleton
    fun provideTodoRepository(tds:TodoDataSource) : TodoRepository{
        return TodoRepository(tds)
    }

    @Provides
    @Singleton
    fun provideTodoDao(@ApplicationContext context : Context) : TodoDao{
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"todo.db")
            .createFromAsset("todo.db").build()
        return vt.getTodoDao()
    }
}