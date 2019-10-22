package com.jit.csi.pojo;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 14:21
 */
public class Zan {
    private Integer commentID;
    private Integer userID;

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public String toString() {
        return "Zan{" +
                "commentID=" + commentID +
                ", userID=" + userID +
                '}';
    }
}
