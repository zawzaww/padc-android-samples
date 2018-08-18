package com.zawzaww.padc.mmnewskotlin.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.zawzaww.padc.mmnewskotlin.fragments.BaseFragment

/**
 * Created by zawzaw on 18/08/2018.
 */

class AccControlPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    var mFragments: ArrayList<Fragment> = ArrayList()
    var mFragmentTitles: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragments[position]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitles[position]
    }

    fun addTab(fragment: BaseFragment, screenTitle: String) {
        mFragments.add(fragment)
        mFragmentTitles.add(screenTitle)
        notifyDataSetChanged()
    }
}