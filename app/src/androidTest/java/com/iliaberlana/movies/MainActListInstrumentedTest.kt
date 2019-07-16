package com.iliaberlana.movies

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.iliaberlana.movies.framework.moviebd.model.toMovie
import com.iliaberlana.movies.ui.MainActivity
import com.iliaberlana.movies.ui.model.UIMovie
import com.iliaberlana.movies.ui.model.toUIMovie
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
class MainActListInstrumentedTest: KoinTest {

    @get:Rule
    val activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    var moviesRepository = MovieRepositoryStub()
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
    fun showRecyclerViewWhenItemsAreOk() {
        val movies: List<UIMovie> = moviesRepository.jsonToList().map { it.toMovie() }.map { it.toUIMovie() }

        activityRule.launchActivity(null)

        onView(withId(R.id.movies_recyclerview)).check(matches(isDisplayed()))
    }

    @Test
    fun doesNotShowLoadingViewOnceErrorAreShown() {
        activityRule.launchActivity(null)

        onView(withId(R.id.movies_progressbar)).check(matches(CoreMatchers.not(isDisplayed())))
    }

}