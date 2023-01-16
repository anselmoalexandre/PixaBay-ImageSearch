package mz.co.bilheteira.pixabayimagesearch.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {
    private const val BASE_URL: String = "https://minha.bilheteira.co.mz/api/v2/"

}