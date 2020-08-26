package com.ristar.movies.mvvm.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ristar.movies.mvvm.data.repositories.MoviesRepository
import kotlinx.coroutines.launch

class MoviesListViewModel(private val moviesRepository: MoviesRepository) : ViewModel() {

    val viewStateLD = MutableLiveData<MoviesListViewState>()

    init {
        viewStateLD.value = MoviesListViewState(progressVisible = true)
    }

    fun loadMovies() {
        viewModelScope.launch {
            val moviesList = moviesRepository.getMovies()
            viewStateLD.postValue(MoviesListViewState(progressVisible = false, data = moviesList))
        }
    }

}