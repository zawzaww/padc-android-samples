package com.zawzaw.hellopadc.data.models;

import com.zawzaw.hellopadc.network.dataagent.NewsDataAgent;
import com.zawzaw.hellopadc.network.dataagent.OkHttpDataAgent;

/**
 * Created by zawzaw on 13/06/2018.
 */

public class NewsModel {

    private static final String DUMMY_ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";

    private static NewsModel objInstance;

    private NewsDataAgent mNewsDataAgent;

    public NewsModel() {
        mNewsDataAgent = OkHttpDataAgent.getInstance();
    }

    public static NewsModel getObjInstance() {
        if (objInstance == null) {
            objInstance = new NewsModel();
        }
        return objInstance;
    }

    public void loadNewsList() {
        mNewsDataAgent.loadNewsList(1, DUMMY_ACCESS_TOKEN);
    }

}
