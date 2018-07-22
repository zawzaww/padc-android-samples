package com.zawzaww.padc.mmnewskotlin.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.zawzaww.padc.mmnewskotlin.R
import com.zawzaww.padc.mmnewskotlin.fragments.LoginFragment

class AccountControlActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_account_control)

        supportFragmentManager.beginTransaction()
                .replace(R.id.flContainer, LoginFragment())
                .commit()

    }

}
