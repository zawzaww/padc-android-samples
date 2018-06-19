package com.zawzaw.hellopadc.events;

import com.zawzaw.hellopadc.data.vos.NewsVO;

import java.util.List;

/**
 * Created by zawzaw on 19/06/2018.
 */

public class SuccessGetNewsEvent {

    private List<NewsVO> newsList;

    public SuccessGetNewsEvent(List<NewsVO> newsList) {
        this.newsList = newsList;
    }

    public List<NewsVO> getNewsList() {
        return newsList;
    }

}
