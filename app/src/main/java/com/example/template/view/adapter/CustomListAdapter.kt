package com.example.template.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.template.R
import com.example.template.network.models.Todo

class CustomListAdapter : RecyclerView.Adapter<CustomViewHolder>() {

    var todos: List<Todo> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_todo, parent, false)
        return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bind(todos[position])
    }

    override fun getItemCount() = todos.size

}

class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val todoTitle: TextView = itemView.findViewById(R.id.todo_title)
    private val todoStatus: TextView = itemView.findViewById(R.id.todo_status)

    fun bind(todo: Todo) {
        todoTitle.text = todo.title
        todoStatus.text = if (todo.completed) {
            "Completed"
        } else {
            "In Progress"
        }
    }
}

