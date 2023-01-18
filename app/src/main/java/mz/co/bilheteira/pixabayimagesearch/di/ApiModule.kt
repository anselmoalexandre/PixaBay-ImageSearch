package mz.co.bilheteira.pixabayimagesearch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import mz.co.bilheteira.pixabayimagesearch.domain.remote.ImageSearchService
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    fun provideImageSearchService(
        retrofit: Retrofit
    ): ImageSearchService = retrofit.create(ImageSearchService::class.java)
}