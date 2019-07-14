package com.iliaberlana.movies.framework.moviebd

import com.iliaberlana.movies.framework.moviebd.model.ResponseMovieDB
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDBClient {
    @GET("/tv/popular")
    suspend fun getMoviesFromDB(
        @Query("apikey") apikey: String,
        @Query("page") page: Int
    ): ResponseMovieDB

}