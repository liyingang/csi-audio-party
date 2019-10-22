package com.jit.csi.pojo;

import java.util.Date;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:32
 */
public class Comments {
    private Integer commentID;
    private Integer articleID;
    private String cmText;
    private String cmAudio;
    private Date cmTime;
    private Integer zan;

    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public Integer getArticleID() {
        return articleID;
    }

    public void setArticleID(Integer articleID) {
        this.articleID = articleID;
    }

    public String getCmText() {
        return cmText;
    }

    public void setCmText(String cmText) {
        this.cmText = cmText;
    }

    public String getCmAudio() {
        return cmAudio;
    }

    public void setCmAudio(String cmAudio) {
        this.cmAudio = cmAudio;
    }

    public Date getCmTime() {
        return cmTime;
    }

    public void setCmTime(Date cmTime) {
        this.cmTime = cmTime;
    }

    public Integer getZan() {
        return zan;
    }

    public void setZan(Integer zan) {
        this.zan = zan;
    }

    @Override
    public String toString() {
        return "Comments{" +
                "commentID=" + commentID +
                ", articleID=" + articleID +
                ", cmText='" + cmText + '\'' +
                ", cmAudio='" + cmAudio + '\'' +
                ", cmTime=" + cmTime +
                ", zan=" + zan +
                '}';
    }
}
