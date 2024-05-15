package com.jbgcomposer.flixhub.domain.use_cases

import com.jbgcomposer.flixhub.data.dto.MovieDataDto
import com.jbgcomposer.flixhub.domain.repository.RemoteDataRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetMovieDataUseCase @Inject constructor(
    private val repository: RemoteDataRepository
) {
    suspend operator fun invoke(title: String): Flow<MovieDataDto> = flow {
        emit(repository.getMovieData(title))
    }
}