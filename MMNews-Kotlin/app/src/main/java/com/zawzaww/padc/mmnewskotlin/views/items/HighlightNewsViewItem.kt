package com.zawzaww.padc.mmnewskotlin.views.items

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO
import kotlinx.android.synthetic.main.view_item_highlight_news.view.*

/**
 * Created by zawzaw on 05/08/2018.
 */

class HighlightNewsViewItem : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun bindData(news: NewsVO) {
        // Highlight News Headtitle name
        tvNewsHeadTitle.text = news.brief
        // Highlight News Background Image
        if (news.images != null && !news.images!!.isEmpty()) {
            Glide.with(context)
                    .load(news.images!![0])
                    .into(ivHighlightNewsBg)
        } else {
            Glide.with(context)
                    .load(news.publication!!.logo)
                    .into(ivHighlightNewsBg)
        }
    }
}