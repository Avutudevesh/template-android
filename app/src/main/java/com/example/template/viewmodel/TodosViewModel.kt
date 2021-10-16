package com.example.template.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.template.network.models.Todo
import com.example.template.repository.TodosRepository
import kotlinx.coroutines.launch

class TodosViewModel(
    private val todosRepository: TodosRepository,
    private val stateMutableLivedata: MutableLiveData<Result>
) : ViewModel() {

    val stateLivedata : LiveData<Result> = stateMutableLivedata

    sealed class Result {
        object Loading: Result()
        data class Success(val todos: List<Todo>) : Result()
        object Error : Result()
    }

    fun getTodos() {
        stateMutableLivedata.value = Result.Loading
        viewModelScope.launch {
            try {
                val todos = todosRepository.getTodos()
                stateMutableLivedata.value = Result.Success(todos)
            } catch (error: Exception) {
                stateMutableLivedata.value = Result.Error
            }
        }
    }
}