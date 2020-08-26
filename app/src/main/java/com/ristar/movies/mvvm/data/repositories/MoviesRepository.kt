package com.ristar.movies.mvvm.data.repositories

import com.ristar.movies.mvvm.data.api.models.Movie

interface MoviesRepository {

    suspend fun getMovies(): List<Movie>?

}