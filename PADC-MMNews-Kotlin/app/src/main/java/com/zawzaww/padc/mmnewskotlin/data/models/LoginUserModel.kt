package com.zawzaww.padc.mmnewskotlin.data.models

import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import com.zawzaww.padc.mmnewskotlin.data.vos.LoginUserVO
import com.zawzaww.padc.mmnewskotlin.events.UserSessionEvent
import com.zawzaww.padc.mmnewskotlin.network.NewsDataAgent

/**
 * Created by zawzaw on 05/08/2018.
 */

class LoginUserModel : BaseModel() {

    companion object {
        private var objInstanceLogin: LoginUserModel? = null

        fun getObjInstance(): LoginUserModel {
            if (objInstanceLogin == null) {
                objInstanceLogin = LoginUserModel()
            }
            val i = objInstanceLogin
            return i!!
        }
    }

    private var mLoginUser: LoginUserVO? = null

    fun isUserLogin(): Boolean {
        return mLoginUser != null
    }

    fun loginUser(phoneNo: String, password: String) {
        NewsDataAgent.getInstance().loginUser(phoneNo, password)
    }

    fun getLoginUser(): LoginUserVO? {
        return mLoginUser
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    fun onSuccessLoginUser(loginUserSuccessEvent: UserSessionEvent.LoginUserSuccessEvent) {
        mLoginUser = loginUserSuccessEvent.loginUser
    }

}