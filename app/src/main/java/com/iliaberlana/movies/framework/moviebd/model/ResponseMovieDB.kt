package com.iliaberlana.movies.framework.moviebd.model

data class ResponseMovieDB(
    val page: Int?,
    val total_results: Int?,
    val total_pages: Int?,
    val results: List<MovieDB>?
)
{
    override fun toString(): String = "ResponseMovieDB {page: $page, totalResults: $total_results, totalPages: $total_pages, results: ${results?.size} }"
}