package mz.co.bilheteira.database

import androidx.room.Database
import androidx.room.RoomDatabase
import mz.co.bilheteira.database.dao.HitsDao
import mz.co.bilheteira.database.entity.ImageEntity

@Database(entities = [ImageEntity::class], exportSchema = false, version = 1)
abstract class HitsDatabase : RoomDatabase() {
    abstract fun getHitsDao(): HitsDao

    companion object {
        const val DB_NAME = "hits.db"
    }
}