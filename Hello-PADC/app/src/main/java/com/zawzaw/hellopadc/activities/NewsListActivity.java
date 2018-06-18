package com.zawzaw.hellopadc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import org.mmtextview.MMFontUtils;

import com.zawzaw.hellopadc.R;
import com.zawzaw.hellopadc.adapters.NewsAdapter;
import com.zawzaw.hellopadc.data.models.NewsModel;
import com.zawzaw.hellopadc.delegates.NewsDelegate;

public class NewsListActivity extends BaseActivity implements NewsDelegate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MMFontUtils.initMMTextView(this);

        RecyclerView rvNews = findViewById(R.id.rv_news);
        NewsAdapter newsAdapter = new NewsAdapter(this);
        rvNews.setAdapter(newsAdapter);

        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL,
                false));

        NewsModel.getObjInstance().loadNewsList();
    }

    @Override
    public void onTapNews() {
        Intent intent = new Intent(getApplicationContext(), NewsDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void onTapFavorite() {

    }

    @Override
    public void onTapComment() {

    }

    @Override
    public void onTapSentTo() {

    }

    @Override
    public void onTapStatistics() {

    }

}
