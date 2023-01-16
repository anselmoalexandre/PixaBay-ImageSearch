package mz.co.bilheteira.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mz.co.bilheteira.database.dao.ImageSearchDao
import mz.co.bilheteira.database.entity.ImageSearchDb

@Database(entities = [ImageSearchDb::class], exportSchema = false, version = 1)
abstract class ImageSearchDatabase : RoomDatabase() {
    abstract fun getImageSearchDao(): ImageSearchDao

    companion object {
        const val DB_NAME = "image_search.db"
    }
}