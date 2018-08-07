package com.zawzaww.padc.mmnewskotlin.fragments


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.adapters.HighlightNewsAdapter

class HighlightFragment : BaseFragment() {

    private lateinit var mAdapter: HighlightNewsAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_highlight, container, false)

    }
}
