package com.kunrambostudio.postreaderkotlin.presentation.postlist

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.blacklenspub.postsreader.util.Logger
import com.kunrambostudio.postreaderkotlin.data.PostRepository
import com.kunrambostudio.postreaderkotlin.data.entity.Post

import javax.inject.Inject

/**
 * Created by rambo on 5/1/2561.
 */
class PostListViewModel : ViewModel() {
    private val TAG = "show_time"

  @Inject  lateinit var logger: Logger
    @Inject lateinit var postRepo: PostRepository

    private var counter = 0

    private var posts: LiveData<List<Post>>? = null

    fun getAllPosts(): LiveData<List<Post>> {
        counter++

        logger.logDebug(TAG, "Counter: $counter")

        posts = posts ?: postRepo.getAllPosts()

        return posts!!
    }

}