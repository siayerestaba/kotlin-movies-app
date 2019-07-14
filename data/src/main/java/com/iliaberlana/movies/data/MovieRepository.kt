package com.iliaberlana.movies.data

import arrow.core.Try
import com.iliaberlana.movies.domain.entities.Movie

interface MovieRepository {
    suspend fun listMovies(page: Int): Try<List<Movie>>
}