package com.kunrambostudio.postreaderkotlin.data

import android.arch.lifecycle.LiveData
import com.kunrambostudio.postreaderkotlin.data.entity.Post

/**
 * Created by rambo on 5/1/2561.
 */
interface PostRepository {

    fun insertOrUpdate(post: Post)

    fun getAllPosts(): LiveData<List<Post>>

    fun getPostById(id: String): LiveData<Post>

}