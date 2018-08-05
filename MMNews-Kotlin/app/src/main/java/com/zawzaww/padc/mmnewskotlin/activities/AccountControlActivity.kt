package com.zawzaww.padc.mmnewskotlin.activities

import android.os.Bundle
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.delegates.LoginDelegate
import com.zawzaww.padc.mmnewskotlin.delegates.RegisterDelegate
import com.zawzaww.padc.mmnewskotlin.fragments.LoginFragment
import com.zawzaww.padc.mmnewskotlin.fragments.RegisterFragment
import com.zawzaww.padc.mmnewskotlin.utils.AppConstants

class AccountControlActivity : BaseActivity(), LoginDelegate, RegisterDelegate {

    override fun onTapAlreadyLogin() {
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.flContainer, LoginFragment())
                .addToBackStack("nvigate-to-login")
                .commit()
    }

    override fun onTapLogin() {
        // To Implement
    }

    override fun onTapRegisterAccount() {
        supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit)
                .replace(R.id.flContainer, RegisterFragment())
                .addToBackStack("navigat-to-register")
                .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_control)

        val actionType = intent.extras.getInt(AppConstants.ACTION_TYPE)

        if (actionType == AppConstants.VALUE_LOGIN) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.flContainer, LoginFragment())
                    .commit()

        } else if (actionType == AppConstants.VALUE_REGISTER) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.flContainer, RegisterFragment())
                    .commit()
        }
    }
}