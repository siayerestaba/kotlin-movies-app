package com.iliaberlana.movies.framework.moviebd.model

data class ResponseMovieDB(
    val page: Int?,
    val total_results: Int?,
    val total_pages: Int?,
    val results: List<MovieDB>?
)