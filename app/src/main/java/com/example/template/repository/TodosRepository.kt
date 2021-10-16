package com.example.template.repository

import com.example.template.network.DataService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class TodosRepository(
    private val dataService: DataService
) {

    suspend fun getTodos() =
        withContext(Dispatchers.IO) {
            dataService.getTodos()
        }

}