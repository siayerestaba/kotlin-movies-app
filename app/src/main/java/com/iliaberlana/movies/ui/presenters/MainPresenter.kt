package com.iliaberlana.movies.ui.presenters

import arrow.core.Either
import com.iliaberlana.movies.R
import com.iliaberlana.movies.domain.exception.DomainError
import com.iliaberlana.movies.ui.commons.logDebug
import com.iliaberlana.movies.ui.model.toUIMovie
import com.iliaberlana.movies.ui.presenters.views.ViewMain
import com.iliaberlana.movies.usecases.ListMovies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainPresenter(
    private val listMovies: ListMovies
) {
    var view: ViewMain? = null
    private var page: Int = 1

    fun create() {
        renderMovies()
    }

    fun refresh() {
        view?.cleanMovies()
        page = 1
        renderMovies()
    }

    private fun renderMovies() {
        view?.showLoading()

        GlobalScope.launch(Dispatchers.Main) {
            val resultMovies = withContext(Dispatchers.IO) { listMovies(page) }
            view?.hideLoading()

            when (resultMovies) {
                is Either.Right -> {
                    view?.hideErrorCase()
                    view?.listMovies(resultMovies.b.map {it.toUIMovie()})
                }
                is Either.Left -> {
                    when (resultMovies.a) {
                        is DomainError.NoInternetConnectionException -> showErrorMessage(R.string.noInternetConectionError)
                        is DomainError.NoMoreMoviesException -> showErrorMessage(R.string.noMoreMovieError)
                        is DomainError.UnknownException -> showErrorMessage(R.string.emptyList)
                    }
                }
            }
        }
    }

    private fun showErrorMessage(stringIdError: Int) {
        if(page == 1) {
            view?.showErrorCase(stringIdError)
        } else {
            view?.showToastMessage(stringIdError)
        }
    }

    fun renderMoreMovies() {
        page = page.plus(1)

        renderMovies()
    }

    fun onDestroy() {
        view = null
    }
}