package mz.co.bilheteira.pixabayimagesearch.repository

import mz.co.bilheteira.database.dao.ImageDao
import mz.co.bilheteira.database.entity.ImageEntity
import mz.co.bilheteira.pixabayimagesearch.domain.data.ApiResponse
import mz.co.bilheteira.pixabayimagesearch.domain.data.ImagesDetails
import mz.co.bilheteira.pixabayimagesearch.domain.data.asImageDetails
import mz.co.bilheteira.pixabayimagesearch.domain.remote.ImageSearchService
import retrofit2.Response

internal class ImageSearchRepositoryImpl(
    private val imageDao: ImageDao,
    private val imageSearchService: ImageSearchService
) : ImageSearchRepository {
    override suspend fun getImageDetails(
        imageId: Int
    ): ImagesDetails = imageDao.getImageDetails(imageId).asImageDetails()

    override suspend fun getLocalImagesDetails(): List<ImagesDetails> {
        return imageDao.getImagesDetails().map {
            ImagesDetails(
                id = it.id,
                user = it.user,
                tags = it.tags,
                likes = it.likes,
                downloads = it.downloads,
                comments = it.comments,
                previewURL = it.previewURL,
                largeImageURL = it.largeImageURL
            )
        }
    }

    override suspend fun cacheImagesDetails(imagesDetailsList: List<ImagesDetails>) =
        imagesDetailsList.map {
            ImageEntity(
                id = it.id,
                user = it.user,
                tags = it.tags,
                likes = it.likes,
                downloads = it.downloads,
                comments = it.comments,
                previewURL = it.previewURL,
                largeImageURL = it.largeImageURL
            )
        }.forEach {
            imageDao.insertImageDetails(it)
        }

    override suspend fun getNetworkImageDetails(
        query: String
    ): Response<ApiResponse> = imageSearchService.getNetworkImagesDetails(query = query)
}