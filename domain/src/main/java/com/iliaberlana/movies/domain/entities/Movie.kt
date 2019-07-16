package com.iliaberlana.movies.domain.entities

data class Movie (
    val id: Int,
    val name: String,
    val image: String?,
    val rating: Float?
)