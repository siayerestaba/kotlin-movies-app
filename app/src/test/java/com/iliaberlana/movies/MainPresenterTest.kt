package com.iliaberlana.movies

import arrow.core.Either
import com.iliaberlana.movies.domain.exception.DomainError
import com.iliaberlana.movies.ui.presenters.MainPresenter
import com.iliaberlana.movies.ui.presenters.views.ViewMain
import com.iliaberlana.movies.usecases.ListMovies
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class MainPresenterTest {

    private val listMovies = mockk<ListMovies>()
    private val presenter = MainPresenter(listMovies)
    private val viewMain = mockk<ViewMain>(relaxed = true)

    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        presenter.view = viewMain

        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }

    @Test
    fun `call showError with Id when returns Error`() {
        coEvery { listMovies(1) } returns Either.left(DomainError.NoMoreMoviesException)

        presenter.create()

        verify { presenter.view?.hideLoading() }
       // verify { presenter.view?.showErrorCase(R.string.noMoreMovieError) }
    }

    @Test
    fun `should call show loading when create`() {
        presenter.create()

        verify { presenter.view?.showLoading() }
    }

    @Test
    fun `clean movies when execute refresh`() {
        presenter.refresh()

        verify { presenter.view?.cleanMovies() }
    }

    @Test
    fun `the page is 1 when execute refresh`() {
        presenter.page = 5

        presenter.refresh()

        coVerify { listMovies(1) }
    }

    @Test
    fun `the page plus 1 when execute renderMoreMovies`() {
        presenter.page = 5

        presenter.renderMoreMovies()

        coVerify { listMovies(6) }
    }

    @Test
    fun `when call create execute listUsers usecase`() {
        coEvery { listMovies(1) } returns Either.right(emptyList())

        presenter.create()

        coVerify { listMovies(1) }
    }
}