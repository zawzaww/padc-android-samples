package com.zawzaww.padc.mmnewskotlin.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_login.view.*
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.delegates.LoginDelegate
import com.zawzaww.padc.mmnewskotlin.events.UserSessionEvent
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * Created by zawzaw on 22/07/2018.
 */

class LoginFragment : BaseFragment() {

    lateinit var mDelegate: LoginDelegate

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mDelegate = context as LoginDelegate
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val loginFragment = inflater.inflate(R.layout.fragment_login, container, false)

        loginFragment.btnRegisterAccount.setOnClickListener {
            mDelegate.onTapRegisterAccount()

        }

        loginFragment.btnLogin.setOnClickListener {
            val phoneNo = etUserPhoneNo.text.toString()
            val password = etUserPassword.text.toString()

            mDelegate.onTapLogin(phoneNo, password)


        }

        return loginFragment
    }

}