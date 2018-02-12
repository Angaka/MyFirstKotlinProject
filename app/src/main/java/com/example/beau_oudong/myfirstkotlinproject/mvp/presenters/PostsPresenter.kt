package com.example.beau_oudong.myfirstkotlinproject.mvp.presenters

import com.example.beau_oudong.myfirstkotlinproject.network.PostsApiInterface
import com.example.beau_oudong.myfirstkotlinproject.mvp.views.interfaces.PostsView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by beau-oudong on 24/01/2018.
 */
class PostsPresenter {

    private var mPostsView: PostsView? = null
    private var mPostsApiInterface: PostsApiInterface? = null

    private var subscription: Disposable? = null

    fun onViewCreated(postsView: PostsView) {
        mPostsView = postsView
    }

    fun setPostsApiInterface(postsApiInterface: PostsApiInterface) {
        mPostsApiInterface = postsApiInterface
    }

    fun loadPosts() {
        subscription = mPostsApiInterface!!
                .getPosts()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(
                { result ->
                    result.map { p -> p.title = "LOL" }
                    result.sortByDescending { it.id }
                    mPostsView?.onPostsItemLoaded(result)
                }, { error ->
                    mPostsView?.onError(error)
                }, {
                    mPostsView?.showComplete()
                })
    }
}