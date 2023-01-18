package com.riyan.movieapp.di

import com.riyan.movieapp.core.domain.usecase.movie.MovieInteractor
import com.riyan.movieapp.core.domain.usecase.movie.MovieUseCase
import com.riyan.movieapp.ui.movie.MovieViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
}

