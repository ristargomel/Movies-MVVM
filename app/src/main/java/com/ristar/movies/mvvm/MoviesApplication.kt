package com.ristar.movies.mvvm

import android.app.Application
import com.ristar.movies.mvvm.di.apiModule
import com.ristar.movies.mvvm.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MoviesApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    appModule,
                    apiModule
                )
            )
        }
    }
}