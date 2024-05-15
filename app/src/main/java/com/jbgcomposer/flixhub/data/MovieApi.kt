package com.jbgcomposer.flixhub.data

import com.jbgcomposer.flixhub.data.dto.MovieDataDto
import com.jbgcomposer.flixhub.data.dto.SearchResultDto
import com.jbgcomposer.flixhub.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface MovieApi {

    @GET("/")
    suspend fun getMovieData(
        @Query("apiKey") apiKey: String = API_KEY,
        @QueryMap options: Map<String, String> = mapOf("plot" to "full", "type" to "movie"),
        @Query("t") title: String
    ): MovieDataDto

    @GET("/")
    suspend fun getSearchResult(
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("type") type: String = "movie",
        @Query("s") search: String
    ): SearchResultDto
}