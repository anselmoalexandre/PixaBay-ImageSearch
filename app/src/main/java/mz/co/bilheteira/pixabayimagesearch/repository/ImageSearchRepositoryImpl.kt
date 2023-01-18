package mz.co.bilheteira.pixabayimagesearch.repository

import mz.co.bilheteira.pixabayimagesearch.domain.data.ApiResponse
import mz.co.bilheteira.pixabayimagesearch.domain.remote.ImageSearchService
import retrofit2.Response

internal class ImageSearchRepositoryImpl(
    private val imageSearchService: ImageSearchService
) : ImageSearchRepository {
    override suspend fun searchImage(
        query: String
    ): Response<ApiResponse> = imageSearchService.searchImage(query = query)
}