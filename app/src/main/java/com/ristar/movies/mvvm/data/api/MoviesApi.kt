package com.ristar.movies.mvvm.data.api

import com.ristar.movies.mvvm.data.api.models.MoviesData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface MoviesApi {

    @GET("movie/popular")
    @Headers("Content-Type:application/json; charset=UTF-8")
    suspend fun getPopularMoviesList(@Query("api_key") apiKey: String, @Query("page") page: Int): MoviesData

}