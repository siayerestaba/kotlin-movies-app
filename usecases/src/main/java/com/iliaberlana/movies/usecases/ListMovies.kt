package com.iliaberlana.movies.usecases

import arrow.core.Either
import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.domain.entities.Movie
import com.iliaberlana.movies.domain.exception.DomainError

class ListMovies (
    private val movieRepository: MovieRepository
) {
    suspend operator fun invoke(page: Int): Either<DomainError, List<Movie>> = movieRepository.listMovies(page)
}