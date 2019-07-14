package com.iliaberlana.movies.domain.entities

data class Movie (
    val id: Int,
    val name: String,
    val image: String,
    val rating: Number
)
{
    override fun toString(): String = "MOVIE {ID: $id, Name: $name, Image: $image, rating: $rating}"
}