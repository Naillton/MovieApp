package com.example.movieapp.presentation.dependencyinjection.module

import android.content.Context
import androidx.room.Room
import com.example.movieapp.data.db.MovieDao
import com.example.movieapp.data.db.TMDBDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    // instanciando o injetor apenas uma unica vez, fazendo a comunicacao com o localData
    @Singleton
    @Provides
    fun provideMovieDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "localMovies"
        ).build()
    }

    // mais uam vez instanciando o injetor apenas uma vez, possibilitando o uso dos metodos
    // presentes no data access object para manipularmos a base de dados local
    @Singleton
    @Provides
    fun provideMovieDAO(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDAO()
    }
}