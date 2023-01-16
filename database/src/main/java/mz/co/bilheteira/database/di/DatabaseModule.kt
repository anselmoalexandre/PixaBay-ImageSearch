package mz.co.bilheteira.database.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import mz.co.bilheteira.database.ImageSearchDatabase
import mz.co.bilheteira.database.dao.ImageSearchDao

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ImageSearchDatabase::class.java,
        ImageSearchDatabase.DB_NAME
    ).fallbackToDestructiveMigration().build()

    @Provides
    fun provideDao(db: ImageSearchDatabase): ImageSearchDao = db.getImageSearchDao()
}