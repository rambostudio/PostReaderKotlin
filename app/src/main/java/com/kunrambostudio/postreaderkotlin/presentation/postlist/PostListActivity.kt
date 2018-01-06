package com.kunrambostudio.postreaderkotlin.presentation.postlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.kunrambostudio.postreaderkotlin.PostsReaderApplication
import com.kunrambostudio.postreaderkotlin.R
import com.kunrambostudio.postreaderkotlin.data.entity.Post
import kotlinx.android.synthetic.main.activity_post_list.*

class PostListActivity : AppCompatActivity() {
    private val TAG = "show_time"
    private val viewModel by lazy {
        ViewModelProviders.of(this).get(PostListViewModel::class.java)
                .also {
                    PostsReaderApplication.component.inject(it)
                }
    }

    val logger = PostsReaderApplication.component.logger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        logger.logDebug(TAG, "onCreate")
        setContentView(R.layout.activity_post_list)

        setupRecyclerView()
        getAllPosts()

    }

    private fun setupRecyclerView() {
        rvPosts.apply {
            setHasFixedSize(true)

            var linearLayoutManager = LinearLayoutManager(this@PostListActivity)
            layoutManager = linearLayoutManager
            addItemDecoration(DividerItemDecoration(context, linearLayoutManager.orientation))


        }

    }

    private fun getAllPosts() {
        viewModel.getAllPosts().observe(this,
                Observer { showPosts(it!!) })
    }

    private fun showPosts(posts: List<Post>) {

    }
}
