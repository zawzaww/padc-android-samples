package com.zawzaw.padcmyanmar.delegates;

import com.zawzaw.padcmyanmar.data.vos.NewsVO;

public interface NewsDelegate {

    void onTapNews(NewsVO news);
    void onTapFavorite(NewsVO news);
    void onTapComment(NewsVO news);
    void onTapSentTo(NewsVO news);
    void onTapStatistics(NewsVO news);

}
