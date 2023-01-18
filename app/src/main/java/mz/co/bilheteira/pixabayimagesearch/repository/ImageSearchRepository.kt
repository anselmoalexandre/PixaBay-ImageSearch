package mz.co.bilheteira.pixabayimagesearch.repository

import mz.co.bilheteira.pixabayimagesearch.domain.data.ApiResponse
import retrofit2.Response

interface ImageSearchRepository {
    suspend fun searchImage(query:String): Response<ApiResponse>
}