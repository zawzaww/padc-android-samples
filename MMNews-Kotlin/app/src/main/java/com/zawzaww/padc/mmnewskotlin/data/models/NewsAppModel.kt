package com.zawzaww.padc.mmnewskotlin.data.models

import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO
import com.zawzaww.padc.mmnewskotlin.events.DataEvent
import com.zawzaww.padc.mmnewskotlin.network.NewsDataAgent
import com.zawzaww.padc.mmnewskotlin.utils.AppConstants

class NewsAppModel : BaseModel() {

    companion object {
        private var INSTANCE: NewsAppModel? = null

        fun getInstance(): NewsAppModel {
            if (INSTANCE == null) {
                INSTANCE = NewsAppModel()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private var mNewsPage: Int = 1
    private var mNewsData: HashMap<String, NewsVO> = HashMap()

    fun loadNews() {
        NewsDataAgent.getInstance().loadNews(AppConstants.ACCESS_TOKEN, mNewsPage)
    }

    fun forceLoadNews() {
        mNewsPage = 1
        mNewsData = HashMap()
        NewsDataAgent.getInstance().loadNews(AppConstants.ACCESS_TOKEN, mNewsPage)
    }

    fun getNews(): List<NewsVO> {
        return ArrayList<NewsVO>(mNewsData.values)
    }

    fun getNewsById(newsId: String): NewsVO? {
        return mNewsData[newsId]
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onNewsLoadedEvent(newsLoadedEvent: DataEvent.NewsLoadedEvent) {
        for (news: NewsVO in newsLoadedEvent.loadedNews) {
            mNewsData[news.newsId] = news
        }
        mNewsPage = newsLoadedEvent.loadedPageIndex + 1
    }
}