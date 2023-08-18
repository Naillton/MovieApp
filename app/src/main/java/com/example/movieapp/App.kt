package com.example.movieapp

import android.app.Application
import com.example.movieapp.presentation.dependencyinjection.interfaces.AppComponent
import com.example.movieapp.presentation.dependencyinjection.interfaces.DaggerAppComponent
import com.example.movieapp.presentation.dependencyinjection.interfaces.Injector
import com.example.movieapp.presentation.dependencyinjection.interfaces.MovieSubComponent
import com.example.movieapp.presentation.dependencyinjection.module.AppModule
import com.example.movieapp.presentation.dependencyinjection.module.NetModule
import com.example.movieapp.presentation.dependencyinjection.module.RemoteDataModule

class App: Application(), Injector {
    private lateinit var appComponent: AppComponent
    private val baseURL = "https://api.themoviedb.org/3/"
    private val apiKey = "3692b8f63aade915e81ff1ac69fc1824"

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(baseURL))
            .remoteDataModule(RemoteDataModule(apiKey))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubomponent().create()
    }
}