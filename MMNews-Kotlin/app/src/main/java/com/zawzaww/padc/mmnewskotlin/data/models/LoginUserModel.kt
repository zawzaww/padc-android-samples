package com.zawzaww.padc.mmnewskotlin.data.models

import com.zawzaww.padc.mmnewskotlin.data.vos.LoginUserVO
import org.greenrobot.eventbus.EventBus

/**
 * Created by zawzaw on 05/08/2018.
 */

class LoginUserModel {

    companion object {
        private var objInstance: LoginUserModel? = null
        fun getObjInstance(): LoginUserModel {
            if (objInstance == null) {
                objInstance = LoginUserModel()
            }
            val i = objInstance
            return i!!
        }
    }

    private constructor() {
        EventBus.getDefault().register(this)

    }

    private var mLoginUser: LoginUserVO? = null

    fun isUserLogin(): Boolean {
        return mLoginUser != null
    }


}