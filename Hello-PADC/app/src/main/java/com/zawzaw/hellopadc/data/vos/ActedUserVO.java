package com.zawzaw.hellopadc.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zawzaw on 12/06/2018.
 */

public class ActedUserVO {

    @SerializedName("user-id")
    private String userId;

    @SerializedName("user-name")
    private String userName;

    @SerializedName("profile-image")
    private String profileImage;

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getProfileImage() {
        return profileImage;
    }

}
