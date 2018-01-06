package com.kunrambostudio.postreaderkotlin.presentation.di

import com.blacklenspub.postsreader.util.Logger
import com.blacklenspub.postsreader.util.UtilModule
import com.kunrambostudio.postreaderkotlin.data.di.LocalDataModule
import com.kunrambostudio.postreaderkotlin.data.di.PostRepositoryModule
import com.kunrambostudio.postreaderkotlin.data.di.RemoteDataModule
import com.kunrambostudio.postreaderkotlin.presentation.postlist.PostListViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * Created by rambo on 6/1/2561.
 */

@Singleton
@Component(
        modules = arrayOf(
                UtilModule::class,

                LocalDataModule::class,
                RemoteDataModule::class,

                PostRepositoryModule::class
        )
)

interface AppComponent {
    val logger: Logger

    fun inject(postListViewModel: PostListViewModel)

}

