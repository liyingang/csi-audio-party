package com.jit.csi.pojo;

import com.jit.csi.util.DateUtils;

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
    private String postTime;
    private Integer postCom;
    private Integer zan;
    private String lastCom;
    private User user;
    private List<Comments> hotComments;
    private List<Comments> newComments;

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

    public String getPostTime() {
        return postTime;
    }

    public void setPostTime(String postTime) {
        this.postTime = postTime;
    }

    public Integer getPostCom() {
        return postCom;
    }

    public void setPostCom(Integer postCom) {
        this.postCom = postCom;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comments> getHotComments() {
        return hotComments;
    }

    public void setHotComments(List<Comments> hotComments) {
        this.hotComments = hotComments;
    }

    public List<Comments> getNewComments() {
        return newComments;
    }

    public void setNewComments(List<Comments> newComments) {
        this.newComments = newComments;
    }

    public String getLastCom() {
        return lastCom;
    }

    public void setLastCom(String lastCom) {
        this.lastCom = lastCom;
    }

    @Override
    public String toString() {
        return "Article{" +
                "articleID=" + articleID +
                ", userID=" + userID +
                ", postTitle='" + postTitle + '\'' +
                ", postText='" + postText + '\'' +
                ", postPageviews=" + postPageviews +
                ", postAudio='" + postAudio + '\'' +
                ", postTime='" + postTime + '\'' +
                ", postCom=" + postCom +
                ", zan=" + zan +
                ", user=" + user +
                ", hotComments=" + hotComments +
                ", newComments=" + newComments +
                '}';
    }
}

