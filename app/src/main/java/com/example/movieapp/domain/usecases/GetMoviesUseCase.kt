package com.example.movieapp.domain.usecases

import com.example.movieapp.data.moviedata.Movie
import com.example.movieapp.domain.repository.MovieRepository

/**
 * Criando clase para UseCase, quando criamos casos de uso passamos como parametro da classe,
 * a interface com os metodos de acesso da api
 */

class GetMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun getMovies(): List<Movie>? = movieRepository.getMovies()
}