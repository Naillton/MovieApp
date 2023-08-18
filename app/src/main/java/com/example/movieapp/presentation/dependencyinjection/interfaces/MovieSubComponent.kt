package com.example.movieapp.presentation.dependencyinjection.interfaces

import com.example.movieapp.presentation.MainActivity
import com.example.movieapp.presentation.dependencyinjection.annotations.MovieScope
import com.example.movieapp.presentation.dependencyinjection.module.MovieModule
import dagger.Subcomponent

@MovieScope
@Subcomponent(modules = [MovieModule::class])
interface MovieSubComponent {
    fun inject(mainActivity: MainActivity)

    @Subcomponent.Factory
    interface Factory {
        fun create(): MovieSubComponent
    }
}