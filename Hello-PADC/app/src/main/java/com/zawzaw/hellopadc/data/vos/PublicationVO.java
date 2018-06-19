package com.zawzaw.hellopadc.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zawzaw on 12/06/2018.
 */

public class PublicationVO {

    @SerializedName("publication-id")
    private String publicationId;

    @SerializedName("title")
    private String title;

    @SerializedName("logo")
    private String logo;

    public String getPublicationId() {
        return publicationId;
    }

    public String getTitle() {
        return title;
    }

    public String getLogo() {
        return logo;
    }

}
