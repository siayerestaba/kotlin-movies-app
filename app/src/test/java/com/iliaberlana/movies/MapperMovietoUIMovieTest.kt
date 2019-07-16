package com.iliaberlana.movies

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isEqualToWithGivenProperties
import com.iliaberlana.movies.domain.entities.Movie
import com.iliaberlana.movies.ui.model.IMAGE_PATH
import com.iliaberlana.movies.ui.model.UIMovie
import com.iliaberlana.movies.ui.model.toUIMovie
import org.junit.Test

class MapperMovietoUIMovieTest {

    @Test
    fun `should return UIMovie from Movie with same values`() {
        val expected = UIMovie("Name of movie", "$IMAGE_PATH/150", 4.5f)

        val movie = Movie(123, "Name of movie", "/150", 4.5f)

        val actual = movie.toUIMovie()

        assertThat(expected).isEqualToWithGivenProperties(actual, UIMovie::name, UIMovie::image)
        assertThat(actual.rating).isEqualTo(expected.rating)
    }
}