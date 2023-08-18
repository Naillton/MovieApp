package com.example.movieapp.domain.usecases

import com.example.movieapp.data.moviedata.Movie
import com.example.movieapp.domain.repository.MovieRepository

/**
 * Criando clase para UseCase, quando criamos casos de uso passamos como parametro da classe,
 *  * a interface com os metodos de acesso da api
 */

class UpdateMoviesUseCase(private val movieRepository: MovieRepository) {

    suspend fun updateMovie(): List<Movie>? = movieRepository.updateMovies()
}