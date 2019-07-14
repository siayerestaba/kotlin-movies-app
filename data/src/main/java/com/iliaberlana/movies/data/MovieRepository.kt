package com.iliaberlana.movies.data

import arrow.core.Either
import com.iliaberlana.movies.domain.entities.Movie
import com.iliaberlana.movies.domain.exception.DomainError

interface MovieRepository {
    suspend fun listMovies(page: Int): Either<DomainError, List<Movie>>
}