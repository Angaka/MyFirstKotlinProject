package com.example.beau_oudong.myfirstkotlinproject.network

import com.example.beau_oudong.myfirstkotlinproject.mvp.models.Post
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by beau-oudong on 22/01/2018.
 */
interface PostsApiInterface {

    @GET("posts")
    fun getPosts(): Observable<ArrayList<Post>>

    @GET("posts/{page}")
    fun getPostsAt(@Path("page") page: Int): Observable<Post>
}