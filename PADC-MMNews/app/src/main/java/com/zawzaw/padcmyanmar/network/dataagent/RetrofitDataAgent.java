package com.zawzaw.padcmyanmar.network.dataagent;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import org.greenrobot.eventbus.EventBus;

import java.util.concurrent.TimeUnit;

import com.zawzaw.padcmyanmar.events.ApiErrorEvent;
import com.zawzaw.padcmyanmar.events.SuccessGetNewsEvent;
import com.zawzaw.padcmyanmar.network.responses.GetNewsResponse;
import com.zawzaw.padcmyanmar.utils.NewsConstants;
import com.zawzaw.padcmyanmar.network.retrofit.RetrofitNewsApi;

/**
 * Created by zawzaw on 21/06/2018.
 */

public class RetrofitDataAgent implements NewsDataAgent {

    private static RetrofitDataAgent objInstance;

    private RetrofitNewsApi mNewsApi;

    private RetrofitDataAgent() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NewsConstants.BASE_API)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        mNewsApi = retrofit.create(RetrofitNewsApi.class);
    }

    public static RetrofitDataAgent getObjInstance() {
        if (objInstance == null) {
            objInstance = new RetrofitDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadNewsList(int page, String accessToken) {

        Call<GetNewsResponse> loadNewsCall = mNewsApi.loadNewsList(accessToken, page);
        loadNewsCall.enqueue(new Callback<GetNewsResponse>() {

            @Override
            public void onResponse(Call<GetNewsResponse> call, Response<GetNewsResponse> response) {

                GetNewsResponse newsResponse = response.body();
                if (newsResponse != null && newsResponse.isResponseOk()) {
                    SuccessGetNewsEvent event = new SuccessGetNewsEvent(newsResponse.getMmNews());
                    EventBus.getDefault().post(event);
                } else {
                    if (newsResponse == null) {
                        ApiErrorEvent errorEvent = new ApiErrorEvent("Empty response.");
                        EventBus.getDefault().post(errorEvent);
                    } else {
                        ApiErrorEvent errorEvent = new ApiErrorEvent(newsResponse.getMessage());
                        EventBus.getDefault().post(errorEvent);
                    }

                }
            }

            @Override
            public void onFailure(Call<GetNewsResponse> call, Throwable t) {
                ApiErrorEvent apiErrorEvent = new ApiErrorEvent(t.getMessage());
                EventBus.getDefault().post(apiErrorEvent);
            }
        });
    }

}
