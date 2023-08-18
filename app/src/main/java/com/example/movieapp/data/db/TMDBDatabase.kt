package com.example.movieapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.movieapp.data.moviedata.Movie

@Database(entities = [Movie::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {

    abstract fun movieDAO(): MovieDao
}