package com.ristar.movies.mvvm.pagination

import androidx.paging.DataSource
import com.ristar.movies.mvvm.data.api.models.Movie
import com.ristar.movies.mvvm.data.repositories.MoviesRepository
import kotlinx.coroutines.CoroutineScope

class MoviesDataSourceFactory(
    private val moviesRepository: MoviesRepository,
    private val scope: CoroutineScope
) : DataSource.Factory<Int, Movie>() {

    override fun create(): DataSource<Int, Movie> {
        return MoviesDataSource(moviesRepository, scope)
    }
}