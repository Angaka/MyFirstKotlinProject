package com.example.beau_oudong.myfirstkotlinproject.shared

import com.example.beau_oudong.myfirstkotlinproject.AppComponent
import com.example.beau_oudong.myfirstkotlinproject.mvp.presenters.PostsPresenter
import com.example.beau_oudong.myfirstkotlinproject.network.PostsApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by beau-oudong on 24/01/2018.
 */
@Module
class PostsModule() {

    @Provides
    @Singleton
    fun providePostsPresenter() = PostsPresenter()

    @Provides
    @Singleton
    internal fun providePostsApiInterface() = Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(PostsApiInterface::class.java)
}