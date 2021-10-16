package com.example.template.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.template.repository.TodosRepository

class TodosViewModelFactory(
    private val todosRepository: TodosRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodosViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TodosViewModel(todosRepository, MutableLiveData()) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}