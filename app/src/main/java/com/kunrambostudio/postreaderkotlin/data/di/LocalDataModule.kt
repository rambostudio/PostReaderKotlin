package com.kunrambostudio.postreaderkotlin.data.di

import android.arch.persistence.room.Room
import android.content.Context
import com.kunrambostudio.postreaderkotlin.data.local.AppDatabase
import com.kunrambostudio.postreaderkotlin.data.local.PostDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by rambo on 5/1/2561.
 */
@Module
class LocalDataModule(val context: Context) {
    private val DB_FILE_NAME = "posts-reader-db"

    @Provides
    @Singleton
    fun providePostDao(db: AppDatabase): PostDao
            = db.postDao()

    @Provides @Singleton
    fun provideAppDatabase(): AppDatabase =
            Room.databaseBuilder(context.applicationContext,
                    AppDatabase::class.java,
                    DB_FILE_NAME)
                    .build()

}