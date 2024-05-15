package com.jbgcomposer.flixhub.domain.use_cases

import com.jbgcomposer.flixhub.data.dto.SearchResultDto
import com.jbgcomposer.flixhub.domain.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetSearchResultUseCase @Inject constructor(
    private val repository: RemoteDataRepository
) {
    suspend operator fun invoke(search: String): Flow<SearchResultDto> = flow {
        emit(repository.getSearchResult(search))
    }
}