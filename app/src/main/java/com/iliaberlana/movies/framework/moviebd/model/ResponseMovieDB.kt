package com.iliaberlana.movies.framework.moviebd.model

data class ResponseMovieDB(
    val page: Int?,
    val totalResults: Int?,
    val totalPages: Int?,
    val results: List<MovieDB>?
)