package com.zawzaw.hellopadc.network.dataagent;

import android.os.AsyncTask;
import android.util.Log;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.zawzaw.hellopadc.events.ApiErrorEvent;
import com.zawzaw.hellopadc.events.SuccessGetNewsEvent;
import com.zawzaw.hellopadc.network.responses.GetNewsResponse;
import com.zawzaw.hellopadc.utils.NewsConstants;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zawzaw on 21/06/2018.
 */

public class OkHttpDataAgent implements NewsDataAgent {

    private static OkHttpDataAgent objInstance;

    private OkHttpClient mHttpClient;

    private OkHttpDataAgent() {
        mHttpClient = new OkHttpClient.Builder() // 1
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    public static OkHttpDataAgent getInstance() {
        if (objInstance == null) {
            objInstance = new OkHttpDataAgent();
        }
        return objInstance;
    }

    @Override
    public void loadNewsList(final int page, final String accessToken) {

        new AsyncTask<Void, Void, String>() {

            @Override
            protected String doInBackground(Void... voids) {

                RequestBody formBody = new FormBody.Builder() // 2
                        .add(NewsConstants.PARAM_ACCESS_TOKEN, accessToken)
                        .add(NewsConstants.PARAM_PAGE, String.valueOf(page))
                        .build();

                Request request = new Request.Builder() // 3
                        .url(NewsConstants.BASE_API + NewsConstants.GET_NEWS)
                        .post(formBody)
                        .build();

                try {
                    Response response = mHttpClient.newCall(request).execute(); // 4

                    if (response.isSuccessful()) {
                        String responseString = response.body().string();
                        return responseString;
                    }

                } catch (IOException e) {
                    Log.e("LoadNewsList", e.getMessage());
                }

                return null;
            }

            @Override
            protected void onPostExecute(String responseString) {
                super.onPostExecute(responseString);

                Gson gson = new Gson();
                GetNewsResponse newsResponse = gson.fromJson(responseString, GetNewsResponse.class);
                Log.d("onPostExecute", "News List Size" + newsResponse.getMmNews().size());

                if (newsResponse.isResponseOk()) {
                    SuccessGetNewsEvent event = new SuccessGetNewsEvent(newsResponse.getMmNews());
                    EventBus.getDefault().post(event);
                } else {
                    ApiErrorEvent apiErrorEvent = new ApiErrorEvent(newsResponse.getMessage());
                    EventBus.getDefault().post(apiErrorEvent);
                }
            }

        }.execute();
    }

}
