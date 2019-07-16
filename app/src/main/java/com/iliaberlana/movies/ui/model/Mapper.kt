package com.iliaberlana.movies.ui.model

import com.iliaberlana.movies.domain.entities.Movie

val IMAGE_PATH = "https://image.tmdb.org/t/p/w500"

fun Movie.toUIMovie(): UIMovie {
    val imageValue = if(!image.isNullOrEmpty()) "$IMAGE_PATH$image" else ""

    return UIMovie(this.name, imageValue, this.rating)
}