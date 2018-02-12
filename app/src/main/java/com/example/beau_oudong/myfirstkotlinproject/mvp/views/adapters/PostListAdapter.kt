package com.example.beau_oudong.myfirstkotlinproject.mvp.views.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.beau_oudong.myfirstkotlinproject.BR
import com.example.beau_oudong.myfirstkotlinproject.R
import com.example.beau_oudong.myfirstkotlinproject.mvp.models.Post

/**
 * Created by beau-oudong on 23/01/2018.
 */
class PostListAdapter(private val listPosts: List<Post>, private val itemClick: (Post) -> Unit) : RecyclerView.Adapter<PostListAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bindPost(listPosts[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, R.layout.item_post, parent, false)
        return ViewHolder(binding, itemClick)
    }

    override fun getItemCount() = listPosts.size

    class ViewHolder(binding: ViewDataBinding, private val itemClick: (Post) -> Unit) : RecyclerView.ViewHolder(binding.root) {
        private val mBinding: ViewDataBinding = binding

        fun bindPost(post: Post) {
            with(post) {
                mBinding.setVariable(BR.post, post)
                mBinding.executePendingBindings()
                itemView.setOnClickListener { itemClick(this) }
            }
        }
    }

    companion object {
        val TAG = "PostListAdapter"
    }
}