package mz.co.bilheteira.pixabayimagesearch.domain.remote

import mz.co.bilheteira.pixabayimagesearch.domain.data.ApiResponse
import mz.co.bilheteira.pixabayimagesearch.domain.data.ImageType
import mz.co.bilheteira.pixabayimagesearch.domain.data.PIXABAY_API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageSearchService {
    @GET("api/")
    suspend fun getNetworkHits(
        @Query("key") key: String = PIXABAY_API_KEY,
        @Query("q") query: String,
        @Query("image_type") image_type: String = ImageType.PHOTO.type
    ): Response<ApiResponse>
}