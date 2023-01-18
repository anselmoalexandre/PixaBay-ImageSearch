package mz.co.bilheteira.pixabayimagesearch.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import mz.co.bilheteira.pixabayimagesearch.domain.remote.ImageSearchService
import mz.co.bilheteira.pixabayimagesearch.repository.ImageSearchRepository
import mz.co.bilheteira.pixabayimagesearch.repository.ImageSearchRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(
        imageSearchService: ImageSearchService
    ): ImageSearchRepository = ImageSearchRepositoryImpl(imageSearchService)
}