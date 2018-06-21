package com.zawzaw.padcmyanmar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.mmtextview.MMFontUtils;

import com.zawzaw.padcmyanmar.R;
import com.zawzaw.padcmyanmar.adapters.NewsAdapter;
import com.zawzaw.padcmyanmar.data.models.NewsModel;
import com.zawzaw.padcmyanmar.delegates.NewsDelegate;
import com.zawzaw.padcmyanmar.events.SuccessGetNewsEvent;

public class NewsListActivity extends BaseActivity implements NewsDelegate {

    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        MMFontUtils.initMMTextView(this);

        RecyclerView rvNews = findViewById(R.id.rv_news);
        mNewsAdapter = new NewsAdapter(this);
        rvNews.setAdapter(mNewsAdapter);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        NewsModel.getObjInstance().loadNewsList();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetNews(SuccessGetNewsEvent event) {
        Log.d("SuccessGetNews", "Success Get NewsList : " + event.getNewsList().size());
        mNewsAdapter.setNewsList(event.getNewsList());
    }

}
