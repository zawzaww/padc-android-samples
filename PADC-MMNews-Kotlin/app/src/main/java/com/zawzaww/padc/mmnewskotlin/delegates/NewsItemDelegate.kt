package com.zawzaww.padc.mmnewskotlin.delegates

import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO

interface NewsItemDelegate {
    fun onTapComment()
    fun onTapSendTo()
    fun onTapFavorite()
    fun onTapStatistics()
    fun onTapNews(news: NewsVO)
}