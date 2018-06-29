package com.zawzaw.padcmyanmar.events;

import java.util.List;

import com.zawzaw.padcmyanmar.data.vos.NewsVO;

/**
 * Created by zawzaw on 29/06/2018.
 */

public class ForceRefreshGetNewsEvent extends SuccessGetNewsEvent {

    public ForceRefreshGetNewsEvent(List<NewsVO> newsList) {
        super(newsList);
    }

}
