package com.example.beau_oudong.myfirstkotlinproject.mvp.views.interfaces

import com.example.beau_oudong.myfirstkotlinproject.mvp.models.Post

/**
 * Created by beau-oudong on 24/01/2018.
 */
interface PostsView {

    fun onPostsItemLoaded(postsItems: ArrayList<Post>)

    fun onError(throwable: Throwable?)

    fun showComplete()
}