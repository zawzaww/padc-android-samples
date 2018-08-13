package com.zawzaww.padc.mmnewskotlin.views.items

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.zawzaww.padc.mmnewskotlin.data.vos.NewsVO

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
        // Bind data logic
    }
}