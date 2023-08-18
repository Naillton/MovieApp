package com.example.movieapp.data.datasource

import com.example.movieapp.data.moviedata.Movie

interface MovieLocalDataSource {

    suspend fun getMoviesFromDB(): List<Movie>

    suspend fun saveMoviesDB(movies: List<Movie>)

    suspend fun deleteMoviesDB()
}