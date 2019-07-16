package com.iliaberlana.movies

import com.iliaberlana.movies.domain.exception.DomainError
import com.iliaberlana.movies.framework.MovieRepositoryImpl
import com.iliaberlana.movies.framework.moviebd.MovieDBClientService
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

        Unit
    }

    @Test
    fun `catch the NoInternetConnectionException and return Try with this error`() = runBlocking {
        coEvery { movieDBClientService.getMoviesFromDB(1) } throws DomainError.NoInternetConnectionException

        val actual = movieRepositoryImpl.listMovies(1)

        Assert.assertTrue(actual.isLeft())

        Unit
    }

}