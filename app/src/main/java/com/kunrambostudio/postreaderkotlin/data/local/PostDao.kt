package com.kunrambostudio.postreaderkotlin.data.local

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.kunrambostudio.postreaderkotlin.data.entity.Post

/**
 * Created by rambo on 5/1/2561.
 */
@Dao
interface PostDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertOrUpdatePosts(vararg posts:Post)

    @Query("Select * from post")
    fun getAllPosts(): LiveData<List<Post>>

    @Query("select * from post where id =:arg0")
    fun getPostById(id: String): LiveData<Post>
}