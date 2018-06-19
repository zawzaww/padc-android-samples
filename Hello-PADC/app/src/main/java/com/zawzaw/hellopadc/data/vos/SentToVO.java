package com.zawzaw.hellopadc.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zawzaw on 13/06/2018.
 */

public class SentToVO {

    @SerializedName("send-to-id")
    private String sentToId;

    @SerializedName("sent-date")
    private String sentDate;

    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    @SerializedName("received-user")
    private ActedUserVO receivedUser;

    public String getSentToId() {
        return sentToId;
    }

    public String getSentDate() {
        return sentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }

}
