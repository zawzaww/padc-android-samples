package com.zawzaww.padc.mmnewskotlin.adapters

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO
import com.zawzaww.padc.mmnewskotlin.views.items.HighlightNewsViewItem

/**
 * Created by zawzaw on 05/08/2018.
 */

class HighlightNewsAdapter : PagerAdapter() {

    private var mData: List<NewsVO> = ArrayList()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object` as HighlightNewsViewItem)
    }

    override fun getCount(): Int {
        return mData.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val viewHighlightNews = inflater.inflate(R.layout.view_item_highlight_news, container, false) as HighlightNewsViewItem

        viewHighlightNews.bindData(mData[position])

        container.addView(viewHighlightNews)
        return viewHighlightNews
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as HighlightNewsViewItem)
    }

    fun setNewsData(newsList: List<NewsVO>) {
        mData = newsList
        notifyDataSetChanged()
    }
}