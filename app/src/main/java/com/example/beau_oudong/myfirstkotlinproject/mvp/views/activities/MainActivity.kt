package com.example.beau_oudong.myfirstkotlinproject.mvp.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log.e
import com.example.beau_oudong.myfirstkotlinproject.AppComponent
import com.example.beau_oudong.myfirstkotlinproject.R
import com.example.beau_oudong.myfirstkotlinproject.mvp.models.Post
import com.example.beau_oudong.myfirstkotlinproject.mvp.presenters.PostsPresenter
import com.example.beau_oudong.myfirstkotlinproject.mvp.views.adapters.PostListAdapter
import com.example.beau_oudong.myfirstkotlinproject.mvp.views.interfaces.PostsView
import com.example.beau_oudong.myfirstkotlinproject.network.PostsApiInterface
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject

class MainActivity : AppCompatActivity(), PostsView {

    @Inject
    lateinit var mPostsPresenter: PostsPresenter
    @Inject
    lateinit var mPostsApiInterface: PostsApiInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvPosts.layoutManager = LinearLayoutManager(this)

        inject()
        mPostsPresenter.setPostsApiInterface(mPostsApiInterface)
        mPostsPresenter.onViewCreated(this)
        mPostsPresenter.loadPosts()
    }

    private fun inject() {
        (application as AppComponent).injector?.inject(this)
    }

    override fun onPostsItemLoaded(postsItems: ArrayList<Post>) {
        rvPosts.adapter = PostListAdapter(postsItems, { startActivity<SecondActivity>(SecondActivity.POST to it) })
    }

    override fun onError(throwable: Throwable?) {
        e(TAG, throwable?.message)
    }

    override fun showComplete() {
        toast("Complete")
    }

    companion object {
        val TAG = "MainActivity"
    }
}
