package com.zawzaw.hellopadc.data.vos;

import java.util.List;

/**
 * Created by zawzaw on 12/06/2018.
 */

public class NewsVO {

    private String newsId;
    private String brief;
    private String details;
    private List<String> images;
    private String postedDate;
    private PublicationVO publication;
    private List<FavoriteVO> favorites;
    private List<CommentVO> comments;
    private List<SentToVO> sentTos;

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
        if (images == null) {

        }
        return images;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<FavoriteVO> getFavorites() {
        return favorites;
    }

    public List<CommentVO> getComments() {
        return comments;
    }

    public List<SentToVO> getSentTos() {
        return sentTos;
    }

}
