package com.example.template.network

import com.example.template.network.models.Todo
import retrofit2.Call
import retrofit2.http.GET

interface DataService {

    @GET("/todos")
    suspend fun getTodos(): List<Todo>

}