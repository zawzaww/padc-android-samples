package com.zawzaw.padcmyanmar.activities;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.zawzaw.padcmyanmar.R;
import com.zawzaw.padcmyanmar.data.models.NewsModel;
import com.zawzaw.padcmyanmar.data.vos.NewsVO;

public class NewsDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_news_details) TextView tvNewsDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        ButterKnife.bind(this, this);

        String newsId = getIntent().getStringExtra("newsId");
        Log.d("NewsDetailActiviy", "newsId : " + newsId);

        NewsVO news = NewsModel.getObjInstance().getNewsById(newsId);

        bindData(news);

    }

    private void bindData(NewsVO news) {
        tvNewsDetails.setText(news.getDetails());

    }

}
