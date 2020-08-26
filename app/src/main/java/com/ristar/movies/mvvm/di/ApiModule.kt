package com.ristar.movies.mvvm.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.ristar.movies.mvvm.BuildConfig
import com.ristar.movies.mvvm.data.api.MoviesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val apiModule: Module = module {


    //Provides Http Client
    single {
        val builder = OkHttpClient.Builder()
            .connectTimeout(1L, TimeUnit.MINUTES)
            .addInterceptor(run {
                val httpLoggingInterceptor = HttpLoggingInterceptor()
                httpLoggingInterceptor.apply {
                    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                }
            })
        builder.build()
    }

    //Provides Gson
    single<Gson> {
        GsonBuilder()
            .serializeNulls()
            .create()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(get()))
            .client(get())
            .build()
    }

    single {
        get<Retrofit>().create(MoviesApi::class.java)
    }

}