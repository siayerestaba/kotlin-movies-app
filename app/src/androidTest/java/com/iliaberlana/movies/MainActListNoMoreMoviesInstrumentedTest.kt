package com.iliaberlana.movies

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.ui.MainActivity
import com.iliaberlana.movies.ui.presenters.MainPresenter
import com.iliaberlana.movies.usecases.ListMovies
import org.hamcrest.CoreMatchers
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import org.koin.test.KoinTest

@RunWith(AndroidJUnit4::class)
class MainActListNoMoreMoviesInstrumentedTest: KoinTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    var moviesRepository: MovieRepository = MovieRepositoryNoMoreMoviesStub()
    val listMovies = ListMovies(moviesRepository)

    @Before
    fun setUp() {
        loadKoinModules(testModule)
    }

    private val testModule = module {
        single(override = true) { moviesRepository }
        single(override = true) { listMovies }

        scope(named<MainActivity>()) {
            scoped(override = true) { MainPresenter(get()) }
        }
    }

    @Test
    fun showErrorTextIfReturnNoMoreMoviesExceptionInPage1() {
        activityRule.launchActivity(null)

        onView(withId(R.id.movies_texterror))
            .check(matches(isDisplayed()))

        onView(withText(R.string.noMoreMovieError))
            .check(matches(isDisplayed()))
    }

    @Test
    fun doesNotShowLoadingViewOnceErrorAreShown() {
        activityRule.launchActivity(null)

        onView(withId(R.id.movies_progressbar)).check(matches(CoreMatchers.not(isDisplayed())))
    }
}