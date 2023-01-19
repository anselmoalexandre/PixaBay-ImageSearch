package mz.co.bilheteira.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mz.co.bilheteira.database.entity.ImageEntity

@Dao
interface ImageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageDetails(search: ImageEntity)

    @Query("SELECT * FROM image")
    suspend fun getImagesDetails() : List<ImageEntity>

    @Query("SELECT * FROM image WHERE id = :imageId")
    suspend fun getImageDetails(imageId:Int): ImageEntity
}