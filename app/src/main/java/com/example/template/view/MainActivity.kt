package com.example.template.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.TemplateApplication
import com.example.template.view.adapter.CustomListAdapter
import com.example.template.viewmodel.TodosViewModel
import com.example.template.viewmodel.TodosViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var todoListView: RecyclerView
    private lateinit var viewModel: TodosViewModel
    private val adapter: CustomListAdapter = CustomListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        setUpViewModel()
    }

    private fun onStateChanged(state: TodosViewModel.Result) {
        when (state) {
            TodosViewModel.Result.Loading -> {
                Toast.makeText(this, "Loading...", Toast.LENGTH_LONG).show()
            }
            TodosViewModel.Result.Error -> {
                Toast.makeText(this, "Sorry, Something went wrong!", Toast.LENGTH_LONG).show()
            }
            is TodosViewModel.Result.Success -> {
                adapter.todos = state.todos
            }
        }
    }

    private fun setUpRecyclerView() {
        todoListView = findViewById(R.id.todo_list)
        todoListView.layoutManager = LinearLayoutManager(this)
        todoListView.adapter = adapter
    }

    private fun setUpViewModel() {
        viewModel = ViewModelProvider(
            this,
            TodosViewModelFactory((application as TemplateApplication).appContainer.todosRepository)
        )[TodosViewModel::class.java]
        viewModel.stateLivedata.observe(this, ::onStateChanged)
        viewModel.getTodos()
    }


}