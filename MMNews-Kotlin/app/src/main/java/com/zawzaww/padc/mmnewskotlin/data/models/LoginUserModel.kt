package com.zawzaww.padc.mmnewskotlin.data.models

import com.zawzaww.padc.mmnewskotlin.data.vos.LoginUserVO

/**
 * Created by zawzaw on 05/08/2018.
 */

class LoginUserModel : BaseModel() {

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

    private var mLoginUser: LoginUserVO? = null

    fun isUserLogin(): Boolean {
        return mLoginUser != null
    }

}