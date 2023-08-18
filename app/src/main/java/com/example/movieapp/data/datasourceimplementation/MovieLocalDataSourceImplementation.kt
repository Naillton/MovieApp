package com.example.movieapp.data.datasourceimplementation

import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.db.MovieDao
import com.example.movieapp.data.moviedata.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * Criando classe de implementacao das funcoes para conectar a base de dados local
 */

class MovieLocalDataSourceImplementation(
    private val movieDao: MovieDao
): MovieLocalDataSource {
    override suspend fun getMoviesFromDB(): List<Movie> {
        val func = CoroutineScope(Dispatchers.Default).async { movieDao.getAllMovies() }
        return func.await()
    }

    override suspend fun saveMoviesDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.save(movies)
        }
    }

    override suspend fun deleteMoviesDB() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}