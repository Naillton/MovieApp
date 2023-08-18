package com.example.movieapp.presentation.dependencyinjection.module

import com.example.movieapp.data.datasource.MovieCacheDataSource
import com.example.movieapp.data.datasourceimplementation.MovieCacheDataSourceImplementation
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheData(): MovieCacheDataSource {
        return MovieCacheDataSourceImplementation()
    }
}