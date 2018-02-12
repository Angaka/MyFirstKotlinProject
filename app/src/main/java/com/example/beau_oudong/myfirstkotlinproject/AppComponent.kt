package com.example.beau_oudong.myfirstkotlinproject

import android.app.Application
import com.example.beau_oudong.myfirstkotlinproject.mvp.views.activities.MainActivity
import com.example.beau_oudong.myfirstkotlinproject.shared.PostsModule
import dagger.Component
import javax.inject.Singleton

/**
 * Created by beau-oudong on 24/01/2018.
 */
class AppComponent : Application() {

    var injector: AppInjector? = null

    @Singleton
    @Component(modules = [PostsModule::class])
    interface AppInjector {
        fun inject(activity: MainActivity)
    }

    override fun onCreate() {
        super.onCreate()
        injector = DaggerAppComponent_AppInjector.builder().build()
    }
}