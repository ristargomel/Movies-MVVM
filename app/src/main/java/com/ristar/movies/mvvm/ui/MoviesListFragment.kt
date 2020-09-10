package com.ristar.movies.mvvm.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.ristar.movies.mvvm.R
import com.ristar.movies.mvvm.data.api.models.Movie
import kotlinx.android.synthetic.main.fragment_movies_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListFragment : Fragment() {

    private val moviesListVM: MoviesListViewModel by viewModel()
    private lateinit var moviesListAdapter: MoviesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movies_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesListAdapter = MoviesListAdapter(::movieClicked)
        recyclerView.adapter = moviesListAdapter

        // moviesListVM.viewStateLD.observe(viewLifecycleOwner, Observer {
        //     Log.d(javaClass.simpleName, "data: ${it.data}")
        //     progressBar.visibility = if (it.progressVisible) View.VISIBLE else View.GONE
        // })

        moviesListVM.movies.observe(viewLifecycleOwner, Observer {
            Log.d(javaClass.simpleName, "moviesListVM: ${it.size}")
            moviesListAdapter.submitList(it)
        })
    }

    private fun movieClicked(movie: Movie) {
        findNavController().navigate(
            MoviesListFragmentDirections.actionMoviesListFragmentToMovieFragment(
                movie
            )
        )
    }
}