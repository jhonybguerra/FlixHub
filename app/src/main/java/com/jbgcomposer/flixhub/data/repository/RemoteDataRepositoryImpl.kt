package com.jbgcomposer.flixhub.data.repository

import com.jbgcomposer.flixhub.data.MovieApi
import com.jbgcomposer.flixhub.data.dto.MovieDataDto
import com.jbgcomposer.flixhub.data.dto.SearchResultDto
import com.jbgcomposer.flixhub.domain.repository.RemoteDataRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataRepositoryImpl @Inject constructor(
    private val api: MovieApi
): RemoteDataRepository {
    override suspend fun getMovieData(title: String): MovieDataDto {
        return withContext(Dispatchers.Default) {
            api.getMovieData(title = title)
        }
    }

    override suspend fun getSearchResult(search: String): SearchResultDto {
        return withContext(Dispatchers.Default) {
            api.getSearchResult(search = search)
        }
    }
}