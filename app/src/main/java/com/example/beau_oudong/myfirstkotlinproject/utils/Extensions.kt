package com.example.beau_oudong.myfirstkotlinproject.utils

import android.widget.TextView

/**
 * Created by beau-oudong on 22/01/2018.
 */

internal inline fun TextView.changeColor(textColor: Int, backgroundColor: Int) {
    setTextColor(textColor)
    setBackgroundResource(backgroundColor)
}