package com.example.template.network.models

import com.squareup.moshi.Json

data class Todo(
    @Json(name = "userId")
    val userId: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "title")
    val title: String,
    @Json(name = "completed")
    val completed: Boolean
)