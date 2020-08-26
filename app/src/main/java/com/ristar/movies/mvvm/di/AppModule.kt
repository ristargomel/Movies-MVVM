package com.ristar.movies.mvvm.di

import com.ristar.movies.mvvm.data.repositories.ApiKeyRepository
import com.ristar.movies.mvvm.data.repositories.MockApiKeyRepository
import com.ristar.movies.mvvm.data.repositories.MoviesRepository
import com.ristar.movies.mvvm.data.repositories.RetrofitMoviesRepository
import com.ristar.movies.mvvm.ui.MoviesListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module {

    single<MoviesRepository> {
        RetrofitMoviesRepository(apiKeyRepository = get(), moviesApi = get())
    }

    single<ApiKeyRepository> {
        MockApiKeyRepository()
    }

    viewModel {
        MoviesListViewModel(moviesRepository = get())
    }

}