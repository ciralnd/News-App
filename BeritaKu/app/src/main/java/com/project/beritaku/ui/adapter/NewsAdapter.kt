package com.project.beritaku.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.project.beritaku.R
import com.project.beritaku.data.remote.response.ArticlesItem
import com.project.beritaku.databinding.ItemNewsContainerBinding
import com.project.beritaku.utils.Constants.dateTimeConverter

class NewsAdapter :
    ListAdapter<ArticlesItem, NewsAdapter.MyViewHolder>(DIFF_CALLBACK) {
    var onNewsClick: ((ArticlesItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemNewsContainerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    inner class MyViewHolder(private val binding: ItemNewsContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: ArticlesItem) {
            binding.apply {
                Glide.with(root)
                    .load(news.urlToImage)
                    .placeholder(R.drawable.dummy_image)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivImgNews)
                tvNewsTitle.text = news.title
                tvTime.text = dateTimeConverter(news.publishedAt)

                root.setOnClickListener {
                    onNewsClick?.invoke(news)
                }
            }
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ArticlesItem>() {
            override fun areItemsTheSame(
                oldItem: ArticlesItem,
                newItem: ArticlesItem
            ): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(
                oldItem: ArticlesItem,
                newItem: ArticlesItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}