package com.example.movieapp.data.datasourceimplementation

import com.example.movieapp.data.api.TMDBService
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import com.example.movieapp.data.moviedata.MovieList
import retrofit2.Response

/**
 * Criando classe de implementacao das funcoes para conectar a api
 */

class MovieRemoteDataSourceImplementation(
    private val tmdbService: TMDBService,
    private val apiKey: String
): MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> =
        tmdbService.getPopularMovies(apiKey)

}