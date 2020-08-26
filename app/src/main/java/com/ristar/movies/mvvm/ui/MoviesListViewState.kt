package com.ristar.movies.mvvm.ui

import com.ristar.movies.mvvm.data.api.models.Movie

data class MoviesListViewState(
    val progressVisible: Boolean,
    val data: List<Movie>? = null
)