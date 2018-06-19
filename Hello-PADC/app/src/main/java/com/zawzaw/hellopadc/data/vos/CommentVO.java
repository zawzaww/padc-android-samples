package com.zawzaw.hellopadc.data.vos;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zawzaw on 12/06/2018.
 */

public class CommentVO {

    @SerializedName("comment-id")
    private String commentId;

    @SerializedName("comment")
    private String comment;

    @SerializedName("comment-date")
    private String commentDate;

    @SerializedName("acted-user")
    private ActedUserVO actedUser;

    public String getCommentId() {
        return commentId;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

}
