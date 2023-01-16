package mz.co.bilheteira.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "image_search")
data class ImageSearchDb(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val tags: String,
    val likes: Int,
    val downloads: Int,
    val comments: Int,
    val previewUrl: String,
    val largeImageURL: String
)
