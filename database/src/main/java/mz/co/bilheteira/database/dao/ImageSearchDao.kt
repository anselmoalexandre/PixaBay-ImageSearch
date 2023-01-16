package mz.co.bilheteira.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mz.co.bilheteira.database.entity.ImageSearchDb

@Dao
interface ImageSearchDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageSearch(search: ImageSearchDb)

    @Query("SELECT * FROM image_search")
    suspend fun getImagesSearch() : List<ImageSearchDb>
}