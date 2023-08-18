package com.example.movieapp.presentation.dependencyinjection.module

import android.content.Context
import com.example.movieapp.presentation.dependencyinjection.interfaces.MovieSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [MovieSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideContextApplication(): Context {
        return context.applicationContext
    }
}