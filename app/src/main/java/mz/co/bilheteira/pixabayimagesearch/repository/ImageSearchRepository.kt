package mz.co.bilheteira.pixabayimagesearch.repository

import mz.co.bilheteira.pixabayimagesearch.domain.data.ApiResponse
import mz.co.bilheteira.pixabayimagesearch.domain.data.ImagesDetails
import retrofit2.Response

interface ImageSearchRepository {
    suspend fun getImageDetails(imageId:Int): ImagesDetails

    suspend fun getLocalImagesDetails(): List<ImagesDetails>

    suspend fun cacheImagesDetails(imagesDetailsList: List<ImagesDetails>)

    suspend fun getNetworkImageDetails(query:String): Response<ApiResponse>
}