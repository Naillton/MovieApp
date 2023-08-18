package com.example.movieapp.presentation.dependencyinjection.module

import com.example.movieapp.data.datasource.MovieLocalDataSource
import com.example.movieapp.data.datasourceimplementation.MovieLocalDataSourceImplementation
import com.example.movieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun providesLocalData(tmdbDatabase: TMDBDatabase): MovieLocalDataSource {
        return MovieLocalDataSourceImplementation(tmdbDatabase.movieDAO())
    }
}