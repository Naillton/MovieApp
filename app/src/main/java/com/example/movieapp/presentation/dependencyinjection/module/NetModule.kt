package com.example.movieapp.presentation.dependencyinjection.module

import com.example.movieapp.data.api.TMDBService
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Injetando dependencias na camada de comunicao com a api.
 * Dessa forma nao precisamos mais criar uma instncia e um companion object para iniciar comunicacoes
 * com a api.
 */

@Module
class NetModule(private val baseUrl: String) {

    // instanciando o injetor apenas uma unica vez, criando uma build do retrofit
    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .baseUrl(baseUrl)
            .build()
    }

    // mais uam vez instanciando o injetor apenas uma vez, criando uma comunicacao com a api
    @Singleton
    @Provides
    fun providesTMDBService(retrofit: Retrofit): TMDBService {
        return retrofit.create(TMDBService::class.java)
    }
}