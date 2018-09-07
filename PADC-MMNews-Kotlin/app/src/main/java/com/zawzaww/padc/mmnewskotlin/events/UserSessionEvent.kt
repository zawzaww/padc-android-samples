package com.zawzaww.padc.mmnewskotlin.events

import com.zawzaww.padc.mmnewskotlin.data.vos.LoginUserVO

/**
 * Created by zawzaw on 05/08/2018.
 */

class UserSessionEvent {

    class LoginUserSuccessEvent(val loginUser: LoginUserVO)

}