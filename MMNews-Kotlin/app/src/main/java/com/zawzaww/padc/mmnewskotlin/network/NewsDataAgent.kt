package com.zawzaww.padc.mmnewskotlin.network

import com.google.gson.Gson
import com.zawzaww.padc.mmnewskotlin.events.DataEvent
import com.zawzaww.padc.mmnewskotlin.events.ErrorEvent
import com.zawzaww.padc.mmnewskotlin.network.responses.GetNewsResponse
import com.zawzaww.padc.mmnewskotlin.network.responses.UserLoginResponse
import okhttp3.OkHttpClient
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NewsDataAgent {

    companion object {
        private var INSTANCE: NewsDataAgent? = null
        fun getInstance(): NewsDataAgent {
            if (INSTANCE == null) {
                INSTANCE = NewsDataAgent()
            }

            val i = INSTANCE
            return i!!
        }
    }

    private val mNewsApi: NewsApi

    private constructor() {
        val okHttpClient = OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build()

        val retrofit = Retrofit.Builder()
                .baseUrl("http://padcmyanmar.com/padc-3/mm-news/apis/")
                .addConverterFactory(GsonConverterFactory.create(Gson()))
                .client(okHttpClient)
                .build()

        mNewsApi = retrofit.create(NewsApi::class.java)
    }

    fun loadNews(accessToken: String, page: Int) {
        val newsResponseCall = mNewsApi.loadMMNews(page, accessToken)
        newsResponseCall.enqueue(object : Callback<GetNewsResponse> {
            override fun onFailure(call: Call<GetNewsResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

            override fun onResponse(call: Call<GetNewsResponse>, response: Response<GetNewsResponse>) {
                val newsResponse: GetNewsResponse? = response.body()
                if (newsResponse != null
                        && newsResponse.getCode() == 200
                        && newsResponse.getNewsList().isNotEmpty()) {
                    val newsLoadedEvent = DataEvent.NewsLoadedEvent(newsResponse.getPageNo(), newsResponse.getNewsList())
                    EventBus.getDefault().post(newsLoadedEvent)
                } else {
                    if (newsResponse != null)
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent(newsResponse.getMessage()))
                    else
                        EventBus.getDefault().post(DataEvent.EmptyDataLoadedEvent())
                }
            }
        })
    }

    fun loginUser(phoneNo: String, password: String) {
        val loginUserCall = mNewsApi.loginUser(phoneNo, password)
        loginUserCall.enqueue(object : Callback<UserLoginResponse> {

            override fun onResponse(call: Call<UserLoginResponse>?, response: Response<UserLoginResponse>?) {
                val loginRespone: UserLoginResponse? = response!!.body()

            }

            override fun onFailure(call: Call<UserLoginResponse>?, t: Throwable?) {
                EventBus.getDefault().post(ErrorEvent.ApiErrorEvent(t))
            }

        })

    }

}