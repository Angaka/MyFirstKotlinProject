package com.example.beau_oudong.myfirstkotlinproject.mvp.views.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.example.beau_oudong.myfirstkotlinproject.R
import com.example.beau_oudong.myfirstkotlinproject.mvp.models.Post
import com.example.beau_oudong.myfirstkotlinproject.utils.changeColor
import kotlinx.android.synthetic.main.activity_second.*

/**
 * Created by beau-oudong on 22/01/2018.
 */
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        textView.text = Integer.toString(count)
        textView.changeColor(R.color.colorPrimary, R.color.colorPrimaryDark)

        val listWithNulls: ArrayList<String?> = arrayListOf("D", "B", null, "C", null, "A")
        listWithNulls.sortBy { it }
        for (item in listWithNulls)
            item?.let { Log.d(TAG, it) }

        val post = intent.getParcelableExtra<Post>(POST)
        post_user_id.text = "user id: ${post.userId}"
        post_id.text = "id: ${post.id}"
        post_title.text = "title: ${post.title}"
        post_body.text = "body: ${post.body}"
    }

    companion object {
        const val TOTAL_COUNT = "total_count"
        const val POST = "post"
        const val TAG = "SecondActivity"
    }
}