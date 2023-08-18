package com.example.movieapp.presentation.dependencyinjection.module

import com.example.movieapp.data.api.TMDBService
import com.example.movieapp.data.datasource.MovieRemoteDataSource
import com.example.movieapp.data.datasourceimplementation.MovieRemoteDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideMovieRemoteData(tmdbService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImplementation(
            tmdbService,
            apiKey
        )
    }
}