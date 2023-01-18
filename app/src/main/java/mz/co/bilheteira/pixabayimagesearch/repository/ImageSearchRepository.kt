package mz.co.bilheteira.pixabayimagesearch.repository

import mz.co.bilheteira.pixabayimagesearch.domain.data.ApiResponse
import mz.co.bilheteira.pixabayimagesearch.domain.data.Hits
import retrofit2.Response

interface ImageSearchRepository {
    suspend fun getHit(id:Int): Hits

    suspend fun getLocalHits(): List<Hits>

    suspend fun cacheHits(hits: List<Hits>)

    suspend fun getNetworkHits(query:String): Response<ApiResponse>
}