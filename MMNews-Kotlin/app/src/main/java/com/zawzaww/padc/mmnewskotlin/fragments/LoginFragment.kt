package com.zawzaww.padc.mmnewskotlin.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.activities.NewsListActivity
import com.zawzaww.padc.mmnewskotlin.delegates.LoginDelegate
import com.zawzaww.padc.mmnewskotlin.events.UserSessionEvent

import kotlinx.android.synthetic.main.fragment_login.view.*

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
            // mDelegate.onTapLogin()
        }

        return loginFragment
    }

    fun onSuccessLoginUser(event: UserSessionEvent) {
//        val intent = Intent(context, NewsListActivity::class.java)
//        startActivity(intent)
        activity!!.onBackPressed()

    }

}