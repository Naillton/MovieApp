package com.example.movieapp.domain.repository

import com.example.movieapp.data.moviedata.Movie

/**
 * Interface que tera funcoes de acesso a api
 */

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?
    suspend fun updateMovies(): List<Movie>?
}