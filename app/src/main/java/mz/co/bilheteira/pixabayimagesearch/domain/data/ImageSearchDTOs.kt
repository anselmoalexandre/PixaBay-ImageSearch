package mz.co.bilheteira.pixabayimagesearch.domain.data

data class Hits(
    val id: Int,
    val name: String,
    val tags: String,
    val likes: Int,
    val downloads: Int,
    val comments: Int,
    val previewUrl: String,
    val largeImageURL: String
)

enum class ImageType(val type:String){
    ALL(type = "all"),
    PHOTO(type = "photo"),
    ILLUSTRATION(type = "illustration")
}

const val PIXABAY_API_KEY = "32883486-c6e656331d840f3347dbb46f2"