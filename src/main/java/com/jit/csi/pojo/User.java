package com.jit.csi.pojo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:01
 */
public class User implements Serializable {
    private Integer userID;
    private String userName;
    private String password;
    private Integer regAge;
    private String regSex;
    private String regEmail;
    private String regPhoto;
    private String admin;
    private String regTime;
    private String loginTime;
    private Integer login;
    private AudioConfig audioConfig;
    public User(){

    }

    public User(String userName, String password, Integer regAge, String regSex, String regEmail) {
        this.userName = userName;
        this.password = password;
        this.regAge = regAge;
        this.regSex = regSex;
        this.regEmail = regEmail;
        this.regPhoto="photo/default.jpg";
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRegAge() {
        return regAge;
    }

    public void setRegAge(Integer regAge) {
        this.regAge = regAge;
    }

    public String getRegSex() {
        return regSex;
    }

    public void setRegSex(String regSex) {
        this.regSex = regSex;
    }

    public String getRegEmail() {
        return regEmail;
    }

    public void setRegEmail(String regEmail) {
        this.regEmail = regEmail;
    }

    public String getRegPhoto() {
        return regPhoto;
    }

    public void setRegPhoto(String regPhoto) {
        this.regPhoto = regPhoto;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    public Integer getLogin() {
        return login;
    }

    public void setLogin(Integer login) {
        this.login = login;
    }

    public AudioConfig getAudioConfig() {
        return audioConfig;
    }

    public void setAudioConfig(AudioConfig audioConfig) {
        this.audioConfig = audioConfig;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", regAge=" + regAge +
                ", regSex='" + regSex + '\'' +
                ", regEmail='" + regEmail + '\'' +
                ", regPhoto='" + regPhoto + '\'' +
                ", admin='" + admin + '\'' +
                ", regTime='" + regTime + '\'' +
                ", loginTime='" + loginTime + '\'' +
                ", login=" + login +
                ", audioConfig=" + audioConfig +
                '}';
    }
}
