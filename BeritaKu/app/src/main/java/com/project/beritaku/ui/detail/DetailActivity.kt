package com.project.beritaku.ui.detail

import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.project.beritaku.R
import com.project.beritaku.data.remote.response.ArticlesItem
import com.project.beritaku.databinding.ActivityDetailBinding
import com.project.beritaku.utils.Constants.dateTimeConverter

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private val newsItem by lazy {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(EXTRA_STORY)
        } else {
            intent.getParcelableExtra(EXTRA_STORY, ArticlesItem::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setViews()
    }

    private fun setViews() {
        binding.apply {
            toolbar.setNavigationOnClickListener { finish() }
            newsItem?.let { news ->
                Glide.with(root)
                    .load(news.urlToImage)
                    .placeholder(R.drawable.dummy_image)
                    .transition(DrawableTransitionOptions.withCrossFade())
                    .into(ivNews)
                tvNewsTitle.text = news.title
                tvTime.text = dateTimeConverter(news.publishedAt)
            }
        }
    }

    companion object {
        const val EXTRA_STORY = "extra_story"
    }
}