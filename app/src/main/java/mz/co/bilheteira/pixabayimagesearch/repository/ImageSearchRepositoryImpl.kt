package mz.co.bilheteira.pixabayimagesearch.repository

import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits
import mz.co.bilheteira.pixabayimagesearch.domain.remote.ImageSearchService
import retrofit2.Response

internal class ImageSearchRepositoryImpl(
    private val imageSearchService: ImageSearchService
) : ImageSearchRepository {
    override suspend fun searchImage(
        query: String
    ): Response<List<Hits>> = imageSearchService.searchImage(query = query)
}