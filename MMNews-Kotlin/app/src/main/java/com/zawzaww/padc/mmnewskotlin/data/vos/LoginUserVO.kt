package com.zawzaww.padc.mmnewskotlin.data.vos

/**
 * Created by zawzaw on 05/08/2018.
 */

class LoginUserVO(userId: Int = 0,
                  name: String = " ",
                  email: String = " ",
                  phoneNo: String = " ",
                  profileUrl: String = " ",
                  coverUrl: String = " ") {

    var userId: Int = userId
    var name: String = name
    var email: String = email
    var phoneNo: String = phoneNo
    var profileUrl: String = profileUrl
    var coverUrl: String = coverUrl

}