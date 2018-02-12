package com.example.beau_oudong.myfirstkotlinproject.mvp.models

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by beau-oudong on 22/01/2018.
 */
@Parcelize
data class Post(@Bindable
                @SerializedName("userId") val userId: Int,
                @Bindable
                @SerializedName("id") val id: Int,
                @Bindable
                @SerializedName("title") var title: String,
                @Bindable
                @SerializedName("body") val body: String) : Parcelable, BaseObservable()