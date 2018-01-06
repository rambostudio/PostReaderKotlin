package com.kunrambostudio.postreaderkotlin.data.di

import com.kunrambostudio.postreaderkotlin.data.PostRepository
import com.kunrambostudio.postreaderkotlin.data.PostRepositoryImpl
import com.kunrambostudio.postreaderkotlin.data.local.PostDao
import com.kunrambostudio.postreaderkotlin.data.remote.PostsReaderApi
import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import java.security.CodeSource
import javax.inject.Singleton

/**
 * Created by rambo on 5/1/2561.
 */
@Module
class PostRepositoryModule {
    @Provides
    @Singleton
    fun providePostRepository(localSource: PostDao
                              , remoteSource: PostsReaderApi)
            : PostRepository = PostRepositoryImpl(localSource, remoteSource, Schedulers.io())

}