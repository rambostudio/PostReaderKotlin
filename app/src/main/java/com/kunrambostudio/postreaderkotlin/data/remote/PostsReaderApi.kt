package com.kunrambostudio.postreaderkotlin.data.remote

import com.kunrambostudio.postreaderkotlin.data.entity.Post
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by rambo on 5/1/2561.
 */
interface PostsReaderApi {

    @GET("posts")
    fun getAllPosts(): Single<List<Post>>

    @GET("posts/{id}")
    fun getPostById(@Path("id") id: String): Single<Post>

}