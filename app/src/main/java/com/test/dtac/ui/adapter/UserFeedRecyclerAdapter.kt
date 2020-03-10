package com.test.dtac.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.test.dtac.databinding.ViewHolderUserFeedBinding
import com.test.dtac.model.response.UseFeedModel

/**
 * Created by PrewSitthirat on 10/3/2020 AD.
 */

class UserFeedRecyclerAdapter : RecyclerView.Adapter<UserFeedRecyclerAdapter.UserFeedViewHolder>() {

    var feedList: MutableList<UseFeedModel>? = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserFeedViewHolder {
        val binding = ViewHolderUserFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserFeedViewHolder(binding.root)
    }

    override fun getItemCount(): Int = feedList?.size ?: 0

    override fun onBindViewHolder(holder: UserFeedViewHolder, position: Int) {
        holder.bindView(feedList!![position])
    }

    inner class UserFeedViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val binding: ViewHolderUserFeedBinding = DataBindingUtil.bind(itemView)!!

        fun bindView(userFeedModel: UseFeedModel) {
            binding.tvId.text = userFeedModel.id
            binding.tvMessage.text = userFeedModel.message
            binding.tvCreatedTime.text = userFeedModel.createdTime
        }
    }
}