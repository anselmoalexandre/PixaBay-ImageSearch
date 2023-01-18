package mz.co.bilheteira.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mz.co.bilheteira.database.dao.ImageDao
import mz.co.bilheteira.database.entity.ImageEntity

@Database(entities = [ImageEntity::class], exportSchema = false, version = 1)
abstract class ImagesDatabase : RoomDatabase() {
    abstract fun getImagesDao(): ImageDao

    companion object {
        const val DB_NAME = "images.db"
    }
}