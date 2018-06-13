package com.zawzaw.hellopadc.data.vos;

/**
 * Created by zawzaw on 12/06/2018.
 */

public class CommentVO {

    private String commentId;
    private String comment;
    private String commentDate;
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
