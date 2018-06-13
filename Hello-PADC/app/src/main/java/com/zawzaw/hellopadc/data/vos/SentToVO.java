package com.zawzaw.hellopadc.data.vos;

/**
 * Created by zawzaw on 13/06/2018.
 */

public class SentToVO {

    private String sentToId;
    private String sentDate;
    private ActedUserVO actedUser;
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
