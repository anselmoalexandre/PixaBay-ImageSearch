package mz.co.bilheteira.pixabayimagesearch.repository

import mz.co.bilheteira.database.dao.HitsDao
import mz.co.bilheteira.database.entity.HitsEntity
import mz.co.bilheteira.pixabayimagesearch.domain.data.ApiResponse
import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits
import mz.co.bilheteira.pixabayimagesearch.domain.data.asHit
import mz.co.bilheteira.pixabayimagesearch.domain.remote.ImageSearchService
import retrofit2.Response

internal class ImageSearchRepositoryImpl(
    private val hitsDao: HitsDao,
    private val imageSearchService: ImageSearchService
) : ImageSearchRepository {
    override suspend fun getHit(id: Int): Hits = hitsDao.getHit(id).asHit()

    override suspend fun getLocalHits(): List<Hits> {
        return hitsDao.getHits().map {
            Hits(
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

    override suspend fun cacheHits(hits: List<Hits>) = hits.map {
        HitsEntity(
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
        hitsDao.insertHit(it)
    }

    override suspend fun getNetworkHits(
        query: String
    ): Response<ApiResponse> = imageSearchService.getNetworkHits(query = query)
}