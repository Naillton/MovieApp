package com.example.movieapp.presentation.dependencyinjection.module

import com.example.movieapp.domain.usecases.GetMoviesUseCase
import com.example.movieapp.domain.usecases.UpdateMoviesUseCase
import com.example.movieapp.presentation.configmodel.ViewModelFactory
import com.example.movieapp.presentation.dependencyinjection.annotations.MovieScope
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): ViewModelFactory {
        return ViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }
}