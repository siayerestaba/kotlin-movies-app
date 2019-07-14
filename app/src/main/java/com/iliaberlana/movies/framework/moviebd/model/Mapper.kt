package com.iliaberlana.movies.framework.moviebd.model

import com.iliaberlana.movies.domain.entities.Movie

fun MovieDB.toMovie(): Movie
        = Movie(this.id!!, this.name!!, this.posterPath!!, this.voteAverage!!)