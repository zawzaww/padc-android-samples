package com.zawzaww.padc.mmnewskotlin.network

import com.zawzaww.padc.mmnewskotlin.network.responses.GetNewsResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface NewsApi {

    @FormUrlEncoded
    @POST("v1/getMMNews.php")
    fun loadMMNews(
            @Field("page") pageIndex: Int,
            @Field("access_token") accessToken: String) : Call<GetNewsResponse>
}