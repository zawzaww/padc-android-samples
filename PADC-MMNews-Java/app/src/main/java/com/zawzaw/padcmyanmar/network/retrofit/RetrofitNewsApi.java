package com.zawzaw.padcmyanmar.network.retrofit;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

import com.zawzaw.padcmyanmar.network.responses.GetNewsResponse;
import com.zawzaw.padcmyanmar.utils.NewsConstants;

/**
 * Created by zawzaw on 21/06/2018.
 */

public interface RetrofitNewsApi {

    @FormUrlEncoded
    @POST(NewsConstants.GET_NEWS)
    Call<GetNewsResponse> loadNewsList(
            @Field(NewsConstants.PARAM_ACCESS_TOKEN) String accesToken,
            @Field(NewsConstants.PARAM_PAGE) int page);

}
