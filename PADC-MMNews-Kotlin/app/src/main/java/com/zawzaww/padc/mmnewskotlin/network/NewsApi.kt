package com.zawzaww.padc.mmnewskotlin.network

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import com.zawzaww.padc.mmnewskotlin.network.responses.GetNewsResponse
import com.zawzaww.padc.mmnewskotlin.network.responses.LoginUserResponse

interface NewsApi {

    companion object {
        // API endpoints
        private const val API_LOAD_NEWS = "v1/getMMNews.php"
        private const val API_LOGIN_USER = "v1/login.php"

        // Param Page and Acccess Token
        private const val PARAM_PAGE = "page"
        private const val PARAM_ACCESS_TOKEN = "access_token"

        // Param User PhoneNo and Password
        private const val PARAM_PHONE_NO = "phoneNo"
        private const val PARAM_PASSWORD = "password"

    }

    @FormUrlEncoded
    @POST(API_LOAD_NEWS)
    fun loadMMNews(
            @Field(PARAM_PAGE) pageIndex: Int,
            @Field(PARAM_ACCESS_TOKEN) accessToken: String): Call<GetNewsResponse>

    @FormUrlEncoded
    @POST(API_LOGIN_USER)
    fun loginUser(
            @Field(PARAM_PHONE_NO) phoneNo: String,
            @Field(PARAM_PASSWORD) password: String): Call<LoginUserResponse>
}