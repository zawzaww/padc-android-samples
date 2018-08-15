package com.zawzaww.padc.mmnewskotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.adapters.NewsDetailsImageAdapter
import com.zawzaww.padc.mmnewskotlin.data.models.NewsAppModel
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : BaseActivity() {

    lateinit var newsDetailsImgAdapter: NewsDetailsImageAdapter

    companion object {
        private const val IE_NEWS_ID = "IE_NEWS_ID"

        fun newIntent(context: Context, newsId: String): Intent {
            val intent: Intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra(IE_NEWS_ID, newsId)

            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        newsDetailsImgAdapter = NewsDetailsImageAdapter()
        vpNewsDetailsImg.adapter = newsDetailsImgAdapter

        val newsId = intent.getStringExtra(IE_NEWS_ID)
        val news = NewsAppModel.getInstance().getNewsById(newsId)

        if (news != null) {
            // DATA Binding for NewsDetails Activity

            // News Details and Description
            tvNewsDetails.text = news.details

            // Publication Logo Image
            Glide.with(applicationContext)
                    .load(news.publication!!.logo)
                    .into(ivPublicationLogo)

            // Publication Title Name
            tvPublicationName.text = news.publication!!.title

            // Published Date
            tvPublishedDate.text = news.postedDate

            // ViewPager Header Images of DetailsActivity
            newsDetailsImgAdapter.setNewsImageData(news.images)
        }
    }

}