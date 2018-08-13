package com.zawzaww.padc.mmnewskotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.adapters.HighlightNewsAdapter
import kotlinx.android.synthetic.main.fragment_highlight.view.*

class HighlightFragment : BaseFragment() {

    private lateinit var mAdapter: HighlightNewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_highlight, container, false)
        mAdapter = HighlightNewsAdapter()
        view.pagerHighlightNews.adapter = mAdapter

        return view
    }


}
