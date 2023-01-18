package com.riyan.movieapp

import android.app.Application
import com.riyan.movieapp.core.di.networkModule
import com.riyan.movieapp.core.di.repositoryModule
import com.riyan.movieapp.di.useCaseModule
import com.riyan.movieapp.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class BaseApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@BaseApplication)
            modules(
                networkModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            )
        }
    }
}