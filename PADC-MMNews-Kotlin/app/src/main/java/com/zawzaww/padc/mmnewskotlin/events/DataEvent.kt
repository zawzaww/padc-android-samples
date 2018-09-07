package com.zawzaww.padc.mmnewskotlin.events

import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO

class DataEvent {

    class NewsLoadedEvent(val loadedPageIndex: Int, val loadedNews: List<NewsVO>)

    class EmptyDataLoadedEvent(val errorMsg: String? = "Empty Body Response")

}