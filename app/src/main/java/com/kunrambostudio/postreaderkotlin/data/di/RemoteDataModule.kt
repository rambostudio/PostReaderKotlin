package com.kunrambostudio.postreaderkotlin.data.di

import com.kunrambostudio.postreaderkotlin.data.remote.PostsReaderApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by rambo on 5/1/2561.
 */

@Module
class RemoteDataModule(val baseUrl: String) {

    @Provides
    @Singleton
    fun providePostsReaderApi(retrofit: Retrofit): PostsReaderApi = retrofit.create(PostsReaderApi::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
            Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
}