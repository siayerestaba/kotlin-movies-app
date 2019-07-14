package com.iliaberlana.movies.ui.presenters

import com.iliaberlana.movies.ui.presenters.views.ViewMain
import com.iliaberlana.movies.usecases.ListMovies

class MainPresenter (
    private val listMovies: ListMovies
) {

    var view: ViewMain? = null

    private var page: Int = 1

    fun create() {
        view?.showLoading()

        renderMovies()
    }

    private fun renderMovies() {
        TODO("not implemented")
    }

    fun renderMoreMovies() {
        page = page.plus(1)

        TODO("not implemented")
    }

    fun onDestroy() {
        view = null
    }
}