package com.iliaberlana.movies

import android.app.Application
import com.iliaberlana.movies.data.MovieRepository
import com.iliaberlana.movies.framework.MovieRepositoryImpl
import com.iliaberlana.movies.ui.MainActivity
import com.iliaberlana.movies.ui.presenters.MainPresenter
import com.iliaberlana.movies.usecases.ListMovies
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

class MoviesApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin{
            androidLogger()
            androidContext(this@MoviesApp)
            modules(appModule)
        }
    }

    private val appModule = module {
        single<MovieRepository> { MovieRepositoryImpl() }
        single { ListMovies(get()) }

        scope(named<MainActivity>()) {
            scoped { MainPresenter(get()) }
        }
    }
}