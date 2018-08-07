package com.zawzaww.padc.mmnewskotlin.network.responses

import com.google.gson.annotations.SerializedName
import com.zawzaww.padc.mmnewskotlin.data.vos.LoginUserVO

/**
 * Created by zawzaw on 05/08/2018.
 */
class UserLoginResponse {

    @SerializedName("code")
    val code: Int = 0

    @SerializedName("message")
    val message: String = " "

    @SerializedName("login_user")
    val loginUser: LoginUserVO? = null

}