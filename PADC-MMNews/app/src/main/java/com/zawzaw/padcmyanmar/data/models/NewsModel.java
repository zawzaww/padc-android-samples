package com.zawzaw.padcmyanmar.data.models;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import com.zawzaw.padcmyanmar.data.vos.NewsVO;
import com.zawzaw.padcmyanmar.events.ForceRefreshGetNewsEvent;
import com.zawzaw.padcmyanmar.events.SuccessGetNewsEvent;
import com.zawzaw.padcmyanmar.network.dataagent.NewsDataAgent;
import com.zawzaw.padcmyanmar.network.dataagent.RetrofitDataAgent;

/**
 * Created by zawzaw on 13/06/2018.
 */

public class NewsModel {

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private static NewsModel objInstance;

    private NewsDataAgent mNewsDataAgent;

    private Map<String, NewsVO> mNewsMap;

    private int mPage;

    public NewsModel() {
        mNewsDataAgent = RetrofitDataAgent.getObjInstance();

        mNewsMap = new HashMap<>();

        EventBus.getDefault().register(this);

        mPage = 1;
    }

    public static NewsModel getObjInstance() {
        if (objInstance == null) {
            objInstance = new NewsModel();
        }
        return objInstance;
    }

    public void loadNewsList() {
        mNewsDataAgent.loadNewsList(mPage, DUMMY_ACCESS_TOKEN, false);
    }

    public void forceRefreshNewsList() {
        mPage = 1;
        mNewsDataAgent.loadNewsList(1, DUMMY_ACCESS_TOKEN, true);
    }

    public NewsVO getNewsById(String newsId) {
        return mNewsMap.get(newsId);
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessGetNews(SuccessGetNewsEvent event) {
        setDataIntoRepository(event.getNewsList());
        mPage++;
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public void onSuccessForceRefreshGetNews(ForceRefreshGetNewsEvent event) {
        setDataIntoRepository(event.getNewsList());
    }

    private void setDataIntoRepository(List<NewsVO> newsList) {
        for (NewsVO news : newsList) {
            mNewsMap.put(news.getNewsId(), news);
        }
    }

}
