package com.iliaberlana.movies.framework

import arrow.core.Try
import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.domain.entities.Movie

class MovieRepositoryImpl : MovieRepository {
    override suspend fun listMovies(page: Int): Try<List<Movie>> {
        TODO("not implemented")
    }
}