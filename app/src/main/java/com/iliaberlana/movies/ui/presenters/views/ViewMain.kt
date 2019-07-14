package com.iliaberlana.movies.ui.presenters.views

import com.iliaberlana.movies.ui.model.UIMovie

interface ViewMain : BaseView {
    fun listMovies(movies: List<UIMovie>)
    fun cleanMovies()
}