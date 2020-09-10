package com.ristar.movies.mvvm.pagination

import androidx.paging.PageKeyedDataSource
import com.ristar.movies.mvvm.data.api.models.Movie
import com.ristar.movies.mvvm.data.repositories.MoviesRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MoviesDataSource(
    private val moviesRepository: MoviesRepository,
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, Movie>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Movie>
    ) {
        loadMovies(1) {
            callback.onResult(it ?: mutableListOf(), null, 1)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        loadMovies(params.key + 1) {
            callback.onResult(it ?: mutableListOf(), params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) = Unit

    private fun loadMovies(page: Int, callback: (List<Movie>?) -> Unit) {
        scope.launch {
            val movies = moviesRepository.getMovies(page)
            callback(movies)
        }
    }
}