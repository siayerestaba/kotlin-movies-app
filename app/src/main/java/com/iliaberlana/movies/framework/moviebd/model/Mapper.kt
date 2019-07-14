package com.iliaberlana.movies.framework.moviebd.model

import com.iliaberlana.movies.domain.entities.Movie

fun MovieDB.toMovie(): Movie
        = Movie(this.id?: 123, this.name?: "", this.poster_path?: "", this.vote_average?: 0.0 as Float)