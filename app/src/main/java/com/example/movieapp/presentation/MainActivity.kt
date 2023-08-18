package com.example.movieapp.presentation

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieapp.R
import com.example.movieapp.databinding.ActivityMainBinding
import com.example.movieapp.presentation.configmodel.MyViewModel
import com.example.movieapp.presentation.configmodel.ViewModelFactory
import com.example.movieapp.presentation.dependencyinjection.interfaces.Injector
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory
    private lateinit var movieViewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        (application as Injector).createMovieSubComponent().inject(this)

        movieViewModel = ViewModelProvider(this,factory)[MyViewModel::class.java]

        initRecyclerView()

        binding.floatingButton.setOnClickListener {
            updateRecyclerView()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerView() {
        binding.recyclerId.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.recyclerId.adapter = adapter
        binding.progressMovies.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressMovies.visibility = View.GONE
            } else {
                binding.progressMovies.visibility = View.GONE
                Toast.makeText(
                    applicationContext,
                    "No data available",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun updateRecyclerView() {
        binding.progressMovies.visibility = View.VISIBLE
        val responseLiveData = movieViewModel.updateMovies()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.progressMovies.visibility = View.GONE
            } else {
                binding.progressMovies.visibility = View.GONE
                Toast.makeText(
                    applicationContext,
                    "No data available",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}