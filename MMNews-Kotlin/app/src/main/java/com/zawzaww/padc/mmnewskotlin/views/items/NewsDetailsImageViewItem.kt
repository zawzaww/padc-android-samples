package com.zawzaww.padc.mmnewskotlin.views.items

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.view_item_news_details_image.view.*

/**
 * Created by zawzaw on 14/08/2018.
 */

class NewsDetailsImageViewItem : FrameLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onFinishInflate() {
        super.onFinishInflate()
    }

    fun setImageData(imgUrl: String) {
        Glide.with(context)
                .load(imgUrl)
                .into(ivNewsDetailsImg)
    }
}