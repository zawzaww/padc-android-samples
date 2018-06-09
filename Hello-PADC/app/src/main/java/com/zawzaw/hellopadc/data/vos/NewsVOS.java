package com.zawzaw.hellopadc.data.vos;

import java.util.List;

public class NewsVOS {

    private String newsId;
    private String brief;
    private String details;
    private List<String> images;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetails() {
        return details;
    }

    public List<String> getImages() {
        return images;
    }

}
