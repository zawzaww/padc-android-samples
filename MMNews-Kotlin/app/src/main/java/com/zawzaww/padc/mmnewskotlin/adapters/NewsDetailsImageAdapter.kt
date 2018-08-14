package com.zawzaww.padc.mmnewskotlin.adapters

import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.views.items.HighlightNewsViewItem
import com.zawzaww.padc.mmnewskotlin.views.items.NewsDetailsImageViewItem

/**
 * Created by zawzaw on 14/08/2018.
 */

class NewsDetailsImageAdapter : PagerAdapter() {

    private var mData: List<String> = ArrayList()

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return (view == `object` as NewsDetailsImageViewItem)
    }

    override fun getCount(): Int {
        return 16
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(container.context)
        val viewNewsDetailsImage = inflater.inflate(R.layout.view_item_news_details_image, container, false)
                as NewsDetailsImageViewItem

        container.addView(viewNewsDetailsImage)
        return viewNewsDetailsImage
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as HighlightNewsViewItem)
    }

}