package com.zawzaw.padcmyanmar.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.mmtextview.MMFontUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.zawzaw.padcmyanmar.R;
import com.zawzaw.padcmyanmar.adapters.NewsAdapter;
import com.zawzaw.padcmyanmar.data.models.NewsModel;
import com.zawzaw.padcmyanmar.data.vos.NewsVO;
import com.zawzaw.padcmyanmar.delegates.NewsDelegate;
import com.zawzaw.padcmyanmar.events.ApiErrorEvent;
import com.zawzaw.padcmyanmar.events.ForceRefreshGetNewsEvent;
import com.zawzaw.padcmyanmar.events.SuccessGetNewsEvent;
import com.zawzaw.padcmyanmar.viewpods.EmptyViewPod;

public class NewsListActivity extends BaseActivity implements NewsDelegate {

    private NewsAdapter mNewsAdapter;

    @BindView(R.id.swipefreshlayout)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.vp_empty)
    EmptyViewPod vpEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);

        MMFontUtils.initMMTextView(this);

        RecyclerView rvNews = findViewById(R.id.rv_news);
        mNewsAdapter = new NewsAdapter(this);

        rvNews.addOnScrollListener(new RecyclerView.OnScrollListener() {

            private boolean isListEndReached = false;

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                Log.d("STATE_CHANGE", "onScrollStateChanged : " + newState);

                if (newState == RecyclerView.SCROLL_STATE_IDLE && ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findLastCompletelyVisibleItemPosition() == recyclerView.getAdapter()
                        .getItemCount() - 1 && !isListEndReached) {
                    isListEndReached = true;
                    NewsModel.getObjInstance().loadNewsList();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                Log.d("ON_SCROLL", "onScrolled - dx : " + dx + ", dy : " + dy);

                int visibleItemCount = recyclerView.getLayoutManager().getChildCount();
                int totalItemCount = recyclerView.getLayoutManager().getItemCount();
                int pastVisibleItems = ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findFirstVisibleItemPosition();

                if (visibleItemCount + pastVisibleItems < totalItemCount) {
                    isListEndReached = false;
                }
            }
        });

        rvNews.setAdapter(mNewsAdapter);
        rvNews.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL, false));

        /*rvNews.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));*/

        NewsModel.getObjInstance().loadNewsList();

        swipeRefreshLayout.setRefreshing(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                NewsModel.getObjInstance().forceRefreshNewsList();
            }
        });

        vpEmptyView.setEmptyData(R.drawable.empty_data_placeholder, getString(R.string.empty_message));

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
    public void onTapNews(NewsVO news) {
        Intent intent = new Intent(getApplicationContext(), NewsDetailsActivity.class);
        intent.putExtra("newsId", news.getNewsId());
        startActivity(intent);
    }

    @Override
    public void onTapFavorite(NewsVO news) {

    }

    @Override
    public void onTapComment(NewsVO news) {

    }

    @Override
    public void onTapSentTo(NewsVO news) {

    }

    @Override
    public void onTapStatistics(NewsVO news) {

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessGetNews(SuccessGetNewsEvent event) {
        Log.d("SuccessGetNews", "Success Get NewsList : " + event.getNewsList().size());
        mNewsAdapter.appendNewsList(event.getNewsList());
        swipeRefreshLayout.setRefreshing(false);
        vpEmptyView.setVisibility(View.GONE);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSuccessForceRefreshGetNews(ForceRefreshGetNewsEvent event) {
        mNewsAdapter.setNewsList(event.getNewsList());
        swipeRefreshLayout.setRefreshing(false);
        vpEmptyView.setVisibility(View.GONE);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onFailGetNews(ApiErrorEvent errorEvent) {
        swipeRefreshLayout.setRefreshing(false);
        if (mNewsAdapter.getItemCount() <= 0) {
            vpEmptyView.setVisibility(View.VISIBLE);
        }
    }

}
