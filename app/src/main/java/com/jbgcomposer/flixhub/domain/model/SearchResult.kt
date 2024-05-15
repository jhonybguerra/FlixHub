package com.jbgcomposer.flixhub.domain.model

import com.jbgcomposer.flixhub.data.dto.Movie

data class SearchResult(
    val movies: List<Movie>
)