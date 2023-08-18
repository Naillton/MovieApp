package com.example.movieapp.presentation

import android.annotation.SuppressLint
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movieapp.R
import com.example.movieapp.data.moviedata.Movie
import com.example.movieapp.databinding.ListItemBinding


class MovieAdapter(): RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: ListItemBinding):
        RecyclerView.ViewHolder(binding.root)

    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )

        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val movie = movieList[position]

        holder.binding.textTitleId.text = movie.title
        holder.binding.contentId.text = movie.overview
        holder.binding.dateId.text = movie.release_date
        val adultColor = Color.argb(255,223,26,26)
        val freeColor = Color.argb(255, 26,223,160)
        if (movie.adult) {
            holder.binding.age.setBackgroundColor(adultColor)
        } else {
            holder.binding.age.setBackgroundColor(freeColor)
        }

        // o tmdb disponibiliza as images por 3 urls diferentes, aqui usei a w500 que deixa a imagem
        // com uam width de 500 e depois passo o caminho da imagem que vem do poster_path e do backdrop
        val postUrl = "https://image.tmdb.org/t/p/w500"+movie.poster_path

        // usando o glide para exibir imagens masi suaves e flexiveis
        Glide.with(holder.binding.imgFrontId.context)
            .load(postUrl)
            .into(holder.binding.imgFrontId)
    }
}