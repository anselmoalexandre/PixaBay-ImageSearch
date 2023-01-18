package mz.co.bilheteira.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mz.co.bilheteira.database.entity.ImageEntity

@Dao
interface HitsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertHit(search: ImageEntity)

    @Query("SELECT * FROM hits")
    suspend fun getHits() : List<ImageEntity>

    @Query("SELECT * FROM hits WHERE id = :hitId")
    suspend fun getHit(hitId:Int): ImageEntity
}