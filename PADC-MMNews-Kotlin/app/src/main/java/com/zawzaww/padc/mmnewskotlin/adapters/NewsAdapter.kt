package com.zawzaww.padc.mmnewskotlin.adapters

import android.content.Context
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO
import com.zawzaww.padc.mmnewskotlin.views.holders.NewsViewHolder
import com.zawzaww.padc.mmnewskotlin.delegates.NewsItemDelegate

class NewsAdapter(context: Context,
                  private val mNewsItemDelegate: NewsItemDelegate) : BaseRecyclerAdapter<NewsViewHolder, NewsVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val newsItemView = mLayoutInflator.inflate(R.layout.view_item_news, parent, false)
        return NewsViewHolder(newsItemView, mNewsItemDelegate)
    }
}