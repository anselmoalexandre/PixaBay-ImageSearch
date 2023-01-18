package mz.co.bilheteira.pixabayimagesearch.domain.data

import mz.co.bilheteira.database.entity.HitsEntity

data class ApiResponse(
    val total: Int,
    val totalHits: Int,
    val hits: List<Hits>
)

data class Hits(
    val id: Int,
    val user: String,
    val tags: String,
    val likes: Int,
    val downloads: Int,
    val comments: Int,
    val previewURL: String,
    val largeImageURL: String
)

enum class ImageType(val type: String) {
    ALL(type = "all"),
    PHOTO(type = "photo"),
    ILLUSTRATION(type = "illustration")
}

const val PIXABAY_API_KEY = "32883486-c6e656331d840f3347dbb46f2"

typealias PositiveActionCallbackHandler = () -> Unit

fun HitsEntity.asHit(): Hits = Hits(
    id = id,
    user = user,
    tags = tags,
    likes = likes,
    downloads = downloads,
    comments = comments,
    previewURL = previewURL,
    largeImageURL = largeImageURL
)
