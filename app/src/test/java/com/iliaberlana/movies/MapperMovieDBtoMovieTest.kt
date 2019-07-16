package com.iliaberlana.movies

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isEqualToWithGivenProperties
import com.iliaberlana.movies.domain.entities.Movie
import com.iliaberlana.movies.framework.moviebd.model.MovieDB
import com.iliaberlana.movies.framework.moviebd.model.toMovie
import org.junit.Test

class MapperMovieDBtoMovieTest {

    @Test
    fun `should return Movie from MovieDB with same values`() {
        val expected = Movie(123, "Name of movie", "https://via.placeholder.com/150", 4.5f)

        val movieDB = MovieDB(123, "Name of movie", "https://via.placeholder.com/150", 4.5f)

        val actual = movieDB.toMovie()

        assertThat(expected).isEqualToWithGivenProperties(actual, Movie::id, Movie::name)
        assertThat(actual.image).isEqualTo(expected.image)
        assertThat(actual.rating).isEqualTo(expected.rating)
    }
}