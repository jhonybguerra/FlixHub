package com.jbgcomposer.flixhub.di

import com.jbgcomposer.flixhub.data.MovieApi
import com.jbgcomposer.flixhub.data.repository.RemoteDataRepositoryImpl
import com.jbgcomposer.flixhub.domain.repository.RemoteDataRepository
import com.jbgcomposer.flixhub.domain.use_cases.GetMovieDataUseCase
import com.jbgcomposer.flixhub.domain.use_cases.GetSearchResultUseCase
import com.jbgcomposer.flixhub.domain.use_cases.UseCases
import com.jbgcomposer.flixhub.util.Constants.BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesMoshi(): Moshi =
        Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

    @Provides
    @Singleton
    fun providesMovieApi(moshi: Moshi): MovieApi =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(MovieApi::class.java)

    @Provides
    @Singleton
    fun providesRepository(movieApi: MovieApi): RemoteDataRepository =
        RemoteDataRepositoryImpl(movieApi)

    @Provides
    @Singleton
    fun providesUseCases(repository: RemoteDataRepository): UseCases =
        UseCases(
            getMovieDataUseCase = GetMovieDataUseCase(repository),
            getSearchResultUseCase = GetSearchResultUseCase(repository)
        )
}