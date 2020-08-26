package com.ristar.movies.mvvm.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ristar.movies.mvvm.R
import com.ristar.movies.mvvm.data.api.models.Movie
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesListAdapter : ListAdapter<Movie, MoviesListAdapter.MoviesVH>(DiffUtilCallBack()) {

    class DiffUtilCallBack : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesVH {
        val inflater = LayoutInflater.from(parent.context)
        return MoviesVH(
            inflater.inflate(
                viewType,
                parent,
                false
            )
        )
    }

    override fun getItemViewType(position: Int): Int = R.layout.item_movie

    override fun onBindViewHolder(holder: MoviesVH, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MoviesVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewTitle: TextView = itemView.textViewName
        private val textViewOverView: TextView = itemView.textViewOverView

        fun bind(movie: Movie) {
            textViewTitle.text = movie.title
            textViewOverView.text = movie.overview
        }
    }
}