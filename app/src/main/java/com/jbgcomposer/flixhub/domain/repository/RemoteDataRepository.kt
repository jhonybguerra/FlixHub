package com.jbgcomposer.flixhub.domain.repository

import com.jbgcomposer.flixhub.data.dto.MovieDataDto
import com.jbgcomposer.flixhub.data.dto.SearchResultDto

interface RemoteDataRepository {

    suspend fun getMovieData(title: String): MovieDataDto

    suspend fun getSearchResult(search: String): SearchResultDto

}