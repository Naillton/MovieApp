package com.example.movieapp.presentation.dependencyinjection.interfaces

interface Injector {
    fun createMovieSubComponent(): MovieSubComponent
}