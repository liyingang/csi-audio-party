package com.jit.csi.pojo;

import java.util.Date;
import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:29
 */
public class Article {
    private Integer articleID;
    private Integer userID;
    private String postTitle;
    private String postText;
    private Integer postPageviews;
    private String postAudio;
    private Date postTime;

     private List<Comments> commentsList;

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public Integer getPostPageviews() {
        return postPageviews;
    }

    public void setPostPageviews(Integer postPageviews) {
        this.postPageviews = postPageviews;
    }

    public String getPostAudio() {
        return postAudio;
    }

    public void setPostAudio(String postAudio) {
        this.postAudio = postAudio;
    }

    public Date getPostTime() {
        return postTime;
    }

    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

    public List<Comments> getCommentsList() {
        return commentsList;
    }

    public void setCommentsList(List<Comments> commentsList) {
        this.commentsList = commentsList;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleID=" + articleID +
                ", postTitle='" + postTitle + '\'' +
                ", postText='" + postText + '\'' +
                ", postPageviews=" + postPageviews +
                ", postAudio='" + postAudio + '\'' +
                ", postTime=" + postTime +
                ", commentsList=" + commentsList +
                '}';
    }
}

