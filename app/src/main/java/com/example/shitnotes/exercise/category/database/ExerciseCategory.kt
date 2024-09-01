package com.example.shitnotes.exercise.category.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise_category")
data class ExerciseCategory(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val colour: String
)
