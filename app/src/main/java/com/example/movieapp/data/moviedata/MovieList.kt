package com.example.movieapp.data.moviedata

import com.google.gson.annotations.SerializedName

/**
 * Para conseguirmos usar json em java temos que dividir o objeto do array, trabalhando de diferentes
 * e simplificando, e da mesma forma que acessamos os atributos do objeto na classe data, tambem,
 * acessaremos o array da mesma forma, se a constante ou varivel nao conter o nome correto ao campo
 * da api passamos o SerializedName para acessa-lo.
 */

data class MovieList(
    /*
    Sem serializedname
    val results: List<Movie>
     */

    // com SerializedName
    @SerializedName("results")
    val movies: List<Movie>
)
