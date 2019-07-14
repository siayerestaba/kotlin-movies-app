package com.iliaberlana.movies.framework.moviebd

import com.iliaberlana.movies.domain.exception.DomainError
import com.iliaberlana.movies.framework.moviebd.model.MovieDB
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieDBClientService {
    private val URL_BASE = "https://api.themoviedb.org/3"
    private val API_KEY = "5d967c7c335764f39b1efbe9c5de9760"

    private val movieDBClient: MovieDBClient

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
            /*.connectTimeout(1, TimeUnit.MINUTES)*/
            .addInterceptor(interceptor) // TODO Borrar producción
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        movieDBClient = retrofit.create(MovieDBClient::class.java)
    }

    suspend fun getMoviesFromDB(page: Int): List<MovieDB> {
        try {
            val reponseMovieDB = movieDBClient.getMoviesFromDB(API_KEY, page)
            return reponseMovieDB.results?: emptyList()
        } catch (error : Error) {
            throw DomainError.NoInternetConnectionException()
        }
    }
}