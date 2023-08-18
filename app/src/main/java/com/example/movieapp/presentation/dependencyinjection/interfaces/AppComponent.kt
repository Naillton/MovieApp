package com.example.movieapp.presentation.dependencyinjection.interfaces

import com.example.movieapp.presentation.dependencyinjection.module.AppModule
import com.example.movieapp.presentation.dependencyinjection.module.CacheDataModule
import com.example.movieapp.presentation.dependencyinjection.module.DatabaseModule
import com.example.movieapp.presentation.dependencyinjection.module.LocalDataModule
import com.example.movieapp.presentation.dependencyinjection.module.NetModule
import com.example.movieapp.presentation.dependencyinjection.module.RemoteDataModule
import com.example.movieapp.presentation.dependencyinjection.module.RepositoryModule
import com.example.movieapp.presentation.dependencyinjection.module.UseCaseModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    CacheDataModule::class,
    DatabaseModule::class,
    LocalDataModule:: class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])
interface AppComponent {

    fun movieSubomponent(): MovieSubComponent.Factory
}