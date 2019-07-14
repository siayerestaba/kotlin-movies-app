package com.iliaberlana.movies.usecases

import arrow.core.Try
import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.domain.entities.Movie

class ListMovies (
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(page: Int): Try<List<Movie>> = movieRepository.listMovies(page)
}