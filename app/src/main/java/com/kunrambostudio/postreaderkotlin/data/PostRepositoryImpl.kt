package com.kunrambostudio.postreaderkotlin.data

import android.arch.lifecycle.LiveData
import com.kunrambostudio.postreaderkotlin.data.entity.Post
import com.kunrambostudio.postreaderkotlin.data.local.PostDao
import com.kunrambostudio.postreaderkotlin.data.remote.PostsReaderApi
import io.reactivex.Scheduler

/**
 * Created by rambo on 5/1/2561.
 */
class PostRepositoryImpl(val localSource: PostDao,
                         val remoteSource: PostsReaderApi,
                         val scheduler: Scheduler) :PostRepository{

    override fun insertOrUpdate(post: Post) {
        localSource.insertOrUpdatePosts(post)
    }

    override fun getAllPosts(): LiveData<List<Post>> {
        remoteSource.getAllPosts()
                .subscribeOn(scheduler)
                .subscribe { posts,_->
                    posts?.let {
                        localSource.insertOrUpdatePosts(*posts.toTypedArray())
                    }
                }
        return localSource.getAllPosts()
    }

    override fun getPostById(id: String): LiveData<Post> {
        remoteSource.getPostById(id)
                .subscribeOn(scheduler)
                .subscribe { post->
                    post?.let { localSource.insertOrUpdatePosts(post) }
                }
        return localSource.getPostById(id)
    }
}