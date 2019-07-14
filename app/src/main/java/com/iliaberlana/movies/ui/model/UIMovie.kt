package com.iliaberlana.movies.ui.model

data class UIMovie(
    val name: String,
    val image: String,
    val rating: Number
)
{
    override fun toString(): String = "UIMOVIE {Name: $name, Image: $image, rating: $rating}"
}