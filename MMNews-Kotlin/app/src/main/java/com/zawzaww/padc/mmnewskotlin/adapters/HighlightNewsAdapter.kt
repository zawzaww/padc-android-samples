package com.zawzaww.padc.mmnewskotlin.adapters

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO
import com.zawzaww.padc.mmnewskotlin.views.items.HighlightViewItem

/**
 * Created by zawzaw on 05/08/2018.
 */

class HighlightNewsAdapter : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private var mData: List<NewsVO> = ArrayList()


    override fun getCount(): Int {
        return mData.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val viewItem = inflater.inflate(R.layout.view_item_highlight_news, container, false)
                as HighlightViewItem

        return viewItem
    }
}