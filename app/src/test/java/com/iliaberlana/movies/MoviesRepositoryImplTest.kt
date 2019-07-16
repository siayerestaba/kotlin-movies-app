package com.iliaberlana.movies

import com.iliaberlana.movies.domain.exception.DomainError
import com.iliaberlana.movies.framework.MovieRepositoryImpl
import com.iliaberlana.movies.framework.moviebd.MovieDBClientService
import io.kotlintest.assertions.arrow.either.shouldBeLeft
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class MoviesRepositoryImplTest {
    private val movieDBClientService = mockk<MovieDBClientService>()
    private val movieRepositoryImpl = MovieRepositoryImpl(movieDBClientService)

    @Test
    fun `call MovieDBClientService when call MoviesRepository with same parameters`() = runBlocking {
        coEvery {movieDBClientService.getMoviesFromDB(1) } returns emptyList()

        movieRepositoryImpl.listMovies(1)

        coVerify {movieDBClientService.getMoviesFromDB(1) }
    }

    @Test
    fun `catch the NoInternetConnectionException and return Either with this error`() = runBlocking {
        coEvery { movieDBClientService.getMoviesFromDB(1) } throws DomainError.NoInternetConnectionException

        val actual = movieRepositoryImpl.listMovies(1)

        actual.shouldBeLeft(DomainError.NoInternetConnectionException)

        Unit
    }

    @Test
    fun `return Either with NoMoreMoviesException error when receive a emptyList`() = runBlocking {
        coEvery { movieDBClientService.getMoviesFromDB(1) } returns emptyList()

        val actual = movieRepositoryImpl.listMovies(1)

        actual.shouldBeLeft(DomainError.NoMoreMoviesException)

        Unit
    }


}