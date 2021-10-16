package com.example.template.injection

import com.example.template.network.DataService
import com.example.template.repository.TodosRepository
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class AppContainer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val dataService: DataService = retrofit.create(DataService::class.java)

    val todosRepository: TodosRepository = TodosRepository(dataService)

}