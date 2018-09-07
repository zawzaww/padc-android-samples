package com.zawzaww.padc.mmnewskotlin.fragments

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.adapters.HighlightNewsAdapter
import com.zawzaww.padc.mmnewskotlin.data.models.NewsAppModel
import com.zawzaww.padc.mmnewskotlin.events.DataEvent
import kotlinx.android.synthetic.main.fragment_highlight.*
import kotlinx.android.synthetic.main.fragment_highlight.view.*

class HighlightFragment : BaseFragment() {

    private lateinit var mAdapter: HighlightNewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_highlight, container, false)
        mAdapter = HighlightNewsAdapter()
        view.pagerHighlightNews.adapter = mAdapter

        view.pagerHighlightNews.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                pivHighlightNews.setCurrentPage(position)

            }
        })

        mAdapter.setNewsData(NewsAppModel.getInstance().getNews())
        view.pivHighlightNews.setNumPage(mAdapter.count)

        return view
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onNewsLoadedEvent(newsLoadedEvent: DataEvent.NewsLoadedEvent) {
        mAdapter.setNewsData(newsLoadedEvent.loadedNews)
        view!!.pivHighlightNews.setNumPage(mAdapter.count)
    }

}
