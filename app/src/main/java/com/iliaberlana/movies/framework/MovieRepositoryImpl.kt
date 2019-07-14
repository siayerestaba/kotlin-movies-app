package com.iliaberlana.movies.framework

import arrow.core.Either
import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.domain.entities.Movie
import com.iliaberlana.movies.domain.exception.DomainError
import com.iliaberlana.movies.framework.moviebd.MovieDBClientService
import com.iliaberlana.movies.framework.moviebd.model.toMovie

class MovieRepositoryImpl(
    private val movieDBClientService: MovieDBClientService
) : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        try {
            val listMoviesDB = movieDBClientService.getMoviesFromDB(page)

            if (listMoviesDB.isEmpty()) return Either.left(DomainError.NoMoreMoviesException)
            return Either.right(listMoviesDB.map { it.toMovie() })
        } catch (noInternetConnectionException: DomainError) {
            return Either.left(DomainError.NoInternetConnectionException())
        } catch (exception : Exception) {
            return Either.left(DomainError.UnknownException)
        }
    }
}