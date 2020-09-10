package com.ristar.movies.mvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ristar.movies.mvvm.data.repositories.MoviesRepository
import com.ristar.movies.mvvm.pagination.MoviesDataSourceFactory

class MoviesListViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    private val moviesDataSource =
        MoviesDataSourceFactory(moviesRepository = moviesRepository, scope = viewModelScope)

    val viewStateLD = MutableLiveData<MoviesListViewState>()
    val movies = LivePagedListBuilder(moviesDataSource, pagedListConfig()).build()

    init {
        viewStateLD.value = MoviesListViewState(progressVisible = true)
    }

    private fun pagedListConfig() = PagedList.Config.Builder()
        .setInitialLoadSizeHint(5)
        .setEnablePlaceholders(false)
        .setPageSize(20)
        .build()
}