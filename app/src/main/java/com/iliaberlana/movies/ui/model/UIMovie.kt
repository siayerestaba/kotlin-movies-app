package com.iliaberlana.movies.ui.model

data class UIMovie(
    val name: String,
    val image: String,
    val rating: Float?
)
{
    override fun toString(): String = "UIMovie {Name: $name, Image: $image, rating: $rating}"
}