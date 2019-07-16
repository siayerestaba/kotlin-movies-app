package com.iliaberlana.movies

import arrow.core.Either
import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.domain.entities.Movie
import com.iliaberlana.movies.domain.exception.DomainError

class MovieRepositoryUnknownStub : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        return Either.left(DomainError.UnknownException)
    }
}

class MovieRepositoryNoInternetConnectionStub : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        return Either.left(DomainError.NoInternetConnectionException)
    }
}

class MovieRepositoryNoMoreMoviesStub : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        return Either.left(DomainError.NoMoreMoviesException)
    }
}

class MovieRepositoryStub : MovieRepository {
    override suspend fun listMovies(page: Int): Either<DomainError, List<Movie>> {
        TODO ("not implemented")
    }
}