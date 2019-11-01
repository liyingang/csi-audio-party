package com.jit.csi.pojo;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-31 - 15:43
 */
public class UaZan {
    private Integer userID;
    private Integer articleID;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    @Override
    public String toString() {
        return "UaZan{" +
                "userID=" + userID +
                ", articleID=" + articleID +
                '}';
    }
}
