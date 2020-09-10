package com.ristar.movies.mvvm.data.repositories

import com.ristar.movies.mvvm.data.api.MoviesApi
import com.ristar.movies.mvvm.data.api.models.Movie

class RetrofitMoviesRepository(
    private val moviesApi: MoviesApi,
    private val apiKeyRepository: ApiKeyRepository
) : MoviesRepository {

    override suspend fun getMovies(page: Int): List<Movie>? {
        return moviesApi.getPopularMoviesList(
            apiKey = apiKeyRepository.getApiKey(),
            page = page
        ).movieList
    }
}