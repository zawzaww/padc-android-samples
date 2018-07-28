package com.zawzaww.padc.mmnewskotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R

/**
 * Created by zawzaw on 22/07/2018.
 */

class LoginFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val loginFragment = inflater.inflate(R.layout.fragment_login, container, false)
        return loginFragment
    }

}