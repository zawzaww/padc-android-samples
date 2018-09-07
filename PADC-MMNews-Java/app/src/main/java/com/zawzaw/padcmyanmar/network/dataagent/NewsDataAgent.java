package com.zawzaw.padcmyanmar.network.dataagent;

/**
 * Created by zawzaw on 14/06/2018.
 */

public interface NewsDataAgent {

    void loadNewsList(int page, String accessToken, boolean isForceRefresh);

}
