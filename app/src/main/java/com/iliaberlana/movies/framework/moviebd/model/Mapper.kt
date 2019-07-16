package com.iliaberlana.movies.framework.moviebd.model

import com.iliaberlana.movies.domain.entities.Movie

fun MovieDB.toMovie(): Movie
        = Movie(this.id?: 0, this.name?: "", this.poster_path, this.vote_average)