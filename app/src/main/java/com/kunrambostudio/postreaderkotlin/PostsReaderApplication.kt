package com.kunrambostudio.postreaderkotlin

import android.app.Application
import com.kunrambostudio.postreaderkotlin.presentation.di.AppComponent

/**
 * Created by rambo on 5/1/2561.
 */
class PostsReaderApplication : Application() {
    companion object {
        lateinit var component : AppComponent
    }
    private val BASE_URL = "http://jsonplaceholder.typicode.com"

    override fun onCreate() {
        super.onCreate()
        buildDependencyGraph()
    }

    private fun buildDependencyGraph() {

//        component = DaggerAppComponent.
    }
}