package com.example.movieapp.data.datasourceimplementation

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.moviedata.Movie

/**
 * Criando classe de cache que implementara a interface de cache, essa funcao servira
 * para tornar a busca e a insercao de dados mais rapida
 */

class MovieCacheDataSourceImplementation: MovieCacheDataSource {
    private var moviesList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return this.moviesList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        this.moviesList.clear()
        this.moviesList = ArrayList(movies)
    }
}