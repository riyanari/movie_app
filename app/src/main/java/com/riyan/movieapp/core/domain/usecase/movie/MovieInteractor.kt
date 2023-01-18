package com.riyan.movieapp.core.domain.usecase.movie

import com.riyan.movieapp.core.data.remote.Resource
import com.riyan.movieapp.core.domain.model.Movie
import com.riyan.movieapp.core.domain.model.TvShow
import com.riyan.movieapp.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val repository: IMovieRepository): MovieUseCase {
    override fun getMovies(): Flow<Resource<List<Movie>>> = repository.getMovies()
    override fun getTvShow(): Flow<Resource<List<TvShow>>> = repository.getTvShow()
}