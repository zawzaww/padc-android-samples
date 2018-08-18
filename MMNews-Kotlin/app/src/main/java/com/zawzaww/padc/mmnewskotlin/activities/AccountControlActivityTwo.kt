package com.zawzaww.padc.mmnewskotlin.activities

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.adapters.AccControlPagerAdapter
import com.zawzaww.padc.mmnewskotlin.delegates.LoginDelegate
import com.zawzaww.padc.mmnewskotlin.delegates.RegisterDelegate
import com.zawzaww.padc.mmnewskotlin.fragments.LoginFragment
import com.zawzaww.padc.mmnewskotlin.fragments.RegisterFragment
import kotlinx.android.synthetic.main.activity_account_control_two.*

class AccountControlActivityTwo : BaseActivity(), LoginDelegate, RegisterDelegate {

    override fun onTapAlreadyLogin() {

    }

    override fun onTapLogin(phoneNo: String, password: String) {

    }

    override fun onTapRegisterAccount() {

    }

    lateinit var mAdapter: AccControlPagerAdapter

    companion object {

        fun newIntent(context: Context): Intent {
            val intent = Intent(context, AccountControlActivityTwo::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_control_two)

        mAdapter = AccControlPagerAdapter(supportFragmentManager)

        mAdapter.addTab(LoginFragment(), "Login")
        mAdapter.addTab(RegisterFragment(), "Register")
        pagerAccControl.adapter = mAdapter

        tlAccControl.setupWithViewPager(pagerAccControl)
    }
}
