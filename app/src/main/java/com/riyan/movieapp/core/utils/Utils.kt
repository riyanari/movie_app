package com.riyan.movieapp.core.utils

import com.riyan.movieapp.core.data.remote.response.MovieResponse
import com.riyan.movieapp.core.data.remote.response.TvShowResponse
import com.riyan.movieapp.core.domain.model.Movie
import com.riyan.movieapp.core.domain.model.TvShow

fun mapMovieResponseToDomain(input: MovieResponse) =
    Movie(
        input.id,
        input.name,
        input.desc,
        input.poster,
        input.imgPreview,
        input.releaseDate
    )

fun mapTvShowResponseToDomain(input: TvShowResponse) =
    TvShow(
        input.id,
        input.name,
        input.desc,
        input.poster,
        input.imgPreview,
        input.releaseDate
    )
