package com.zawzaw.hellopadc.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zawzaw on 12/06/2018.
 */

public class FavoriteVO {

    @SerializedName("favorite-id")
    private String favoriteId;

    @SerializedName("favorite-date")
    private String favoriteDate;

    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    public String getFavoriteId() {
        return favoriteId;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

}
