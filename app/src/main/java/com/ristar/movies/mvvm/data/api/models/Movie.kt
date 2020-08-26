package com.ristar.movies.mvvm.data.api.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    @SerializedName("id")
    val id: Long,

    @SerializedName("vote_count")
    val voteCount: Int,

    @SerializedName("vote_average")
    val voteAverage: Float,

    @SerializedName("title")
    val title: String?,

    @SerializedName("popularity")
    val popularity: Float,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("original_language")
    val originalLanguage: String?,

    @SerializedName("original_title")
    val originalTitle: String?,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("release_date")
    val releaseDate: String?
): Parcelable


data class MovieDetails(
    @SerializedName("id")
    val id: Long,

    @SerializedName("backdrop_path")
    val backdropPath: String?,

    @SerializedName("adultb")
    val adultb: Boolean,

    @SerializedName("budget")
    val budget: Long,

    @SerializedName("genres")
    val genresList: List<Genre>?,

    @SerializedName("homepage")
    val homepage: String?,

    @SerializedName("imdb_id")
    val imdbId: String?,

    @SerializedName("original_language")
    val originalLanguage: String?,

    @SerializedName("original_title")
    val originalTitle: String?,

    @SerializedName("overview")
    val overview: String?,

    @SerializedName("popularity")
    val popularity: String?,

    @SerializedName("poster_path")
    val posterPath: String?,

    @SerializedName("release_date")
    val releaseDate: String?,

    @SerializedName("revenue")
    val revenue: Long,

    @SerializedName("runtime")
    val runtime: Int,

    @SerializedName("status")
    val status: String?,

    @SerializedName("tagline")
    val tagline: String?,

    @SerializedName("title")
    val title: String?,

    @SerializedName("video")
    val video: Boolean,

    @SerializedName("vote_average")
    val voteAverage: Float,

    @SerializedName("vote_count")
    val voteCount: Int
)

data class MoviesData(

    @SerializedName("page")
    val page: Int,

    @SerializedName("total_results")
    val totalResults: Int,

    @SerializedName("total_pages")
    val totalPages: Int,

    @SerializedName("results")
    val movieList: List<Movie>?

)