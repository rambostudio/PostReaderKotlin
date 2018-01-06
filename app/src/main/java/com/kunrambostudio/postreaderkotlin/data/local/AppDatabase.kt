package com.kunrambostudio.postreaderkotlin.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.kunrambostudio.postreaderkotlin.data.entity.Post

/**
 * Created by rambo on 5/1/2561.
 */

@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao

}