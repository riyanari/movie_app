package com.riyan.movieapp.ui.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.riyan.movieapp.core.domain.usecase.movie.MovieUseCase

class TvShowViewModel(private val useCase: MovieUseCase): ViewModel() {
    fun getTvShow() = useCase.getTvShow().asLiveData()
}