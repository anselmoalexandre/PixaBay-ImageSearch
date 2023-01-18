package mz.co.bilheteira.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hits")
data class HitsEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val user: String,
    val tags: String,
    val likes: Int,
    val downloads: Int,
    val comments: Int,
    val previewURL: String,
    val largeImageURL: String
)
