package com.example.todoapp.data.entity

import java.io.Serializable

data class Task(
    var task_id: Int,
    var task_title: String,
    var task_describe: String
) : Serializable {
}