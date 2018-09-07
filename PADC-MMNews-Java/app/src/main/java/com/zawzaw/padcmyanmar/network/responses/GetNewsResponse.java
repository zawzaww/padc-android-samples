package com.zawzaw.padcmyanmar.network.responses;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.zawzaw.padcmyanmar.data.vos.NewsVO;

/**
 * Created by zawzaw on 19/06/2018.
 */

public class GetNewsResponse {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("apiVersion")
    private String apiVersion;

    @SerializedName("page")
    private String page;

    @SerializedName("mmNews")
    private List<NewsVO> mmNews;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewsVO> getMmNews() {
        return mmNews;
    }

    public boolean isResponseOk() {
        return (code == 200 && mmNews != null);
    }

}
