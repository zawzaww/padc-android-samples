package com.zawzaww.padc.mmnewskotlin.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.delegates.RegisterDelegate
import kotlinx.android.synthetic.main.fragment_register.view.*

class RegisterFragment : BaseFragment() {

    lateinit var mDelegate: RegisterDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mDelegate = context as RegisterDelegate
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val registerFragment = inflater.inflate(R.layout.fragment_register, container, false)

        registerFragment.btnAlreadyLogin.setOnClickListener {
            mDelegate.onTapAlreadyLogin()
        }

        return registerFragment
    }

}