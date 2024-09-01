package com.example.shitnotes.exercise.category.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [ExerciseCategory::class],
    version = 1
)
abstract class ExerciseCategoryDatabase: RoomDatabase() {
    abstract val dao: ExerciseCategoryDao
}