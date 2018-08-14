package com.zawzaww.padc.mmnewskotlin.activities

import android.os.Bundle
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.adapters.NewsDetailsImageAdapter
import kotlinx.android.synthetic.main.activity_news_details.*

class NewsDetailsActivity : BaseActivity() {

    lateinit var newsDetailsImgAdapter: NewsDetailsImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)

        newsDetailsImgAdapter = NewsDetailsImageAdapter()
        vpNewsDetailsImg.adapter = newsDetailsImgAdapter

    }

}