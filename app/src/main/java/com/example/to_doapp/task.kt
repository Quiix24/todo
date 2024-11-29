package com.example.to_doapp.models

import java.sql.Date

data class Task(
    val name: String,
    val details: String,
) {
    var isCompleted: Boolean = false
}