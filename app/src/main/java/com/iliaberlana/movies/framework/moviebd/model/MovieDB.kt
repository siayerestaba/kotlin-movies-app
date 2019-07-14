package com.iliaberlana.movies.framework.moviebd.model

data class MovieDB (
    val id: Int?,
    val name: String?,
    val poster_path: String?,
    val vote_average: Float?
)
{
    override fun toString(): String = "MovieDB {ID: $id, Name: $name, posterPath: $poster_path, voteAverage: $vote_average}"
}