package com.example.movieapp.data

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import com.example.movieapp.data.moviedata.Movie
import com.example.movieapp.domain.repository.MovieRepository

/**
 * Criando classe que conectara nossa cmada de domain com a camada data
 */

class MovieRepositoryImplementation(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieLocalDataSource: MovieLocalDataSource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDataSource.deleteMoviesDB()
        movieLocalDataSource.saveMoviesDB(newListOfMovies)
        movieCacheDataSource.saveMoviesToCache(newListOfMovies)
        return newListOfMovies
    }

    // funcao de acesso aos filmes da api
    suspend fun getMoviesFromAPI(): List<Movie> {

        // iniciando varivel que tem como tipo uma lista de filmes
        lateinit var movieList: List<Movie>

        // bloco try que tenta receber informacoes do body da aplicacao depois de fazer uma chamada
        // caso contrario uma exception ocorre
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (_: Exception) {}

        return movieList
    }

    // funcao de acesso aos filmes da base de dados local
    suspend fun getMoviesFromROOM(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDB()
        } catch (_: Exception) {}

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDataSource.saveMoviesDB(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie>? {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCache()
        } catch (_: Exception) {}

        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromROOM()
            movieCacheDataSource.saveMoviesToCache(movieList)
        }

        return movieList
    }
}