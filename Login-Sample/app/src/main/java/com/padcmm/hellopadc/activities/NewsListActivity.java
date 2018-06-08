package com.padcmm.hellopadc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import com.padcmm.hellopadc.R;
import com.padcmm.hellopadc.adapters.NewsAdapter;
import com.padcmm.hellopadc.delegates.NewsDelegate;
import org.mmtextview.MMFontUtils;

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
