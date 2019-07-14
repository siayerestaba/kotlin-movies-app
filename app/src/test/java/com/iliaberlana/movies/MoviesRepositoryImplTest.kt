package com.iliaberlana.movies

import com.iliaberlana.movies.framework.MovieRepositoryImpl
import com.iliaberlana.movies.framework.moviebd.MovieDBClientService
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.mockito.Mockito.*

class MoviesRepositoryImplTest {
    private val movieDBClientService = mock(MovieDBClientService::class.java)
    private val movieRepositoryImpl = MovieRepositoryImpl(movieDBClientService)

    @Test
    fun `call MovieDBClientService when call MoviesRepository with same parameters`() = runBlocking {
        `when`(movieDBClientService.getMoviesFromDB(1)).thenReturn(emptyList())

        movieRepositoryImpl.listMovies(1)

        verify(movieDBClientService).getMoviesFromDB(1)

        Unit
    }
}