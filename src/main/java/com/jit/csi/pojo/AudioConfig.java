package com.jit.csi.pojo;

/**
 * @author Liyingang
 * @version 1.0.0 2019-10-22 - 11:17
 */
public class AudioConfig {
    private Integer userID;
    private Integer auSetVol;
    private Integer auSetVoiPer;
    private Integer auSetSpd;
    private Integer auSetPit;

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Integer getAuSetVol() {
        return auSetVol;
    }

    public void setAuSetVol(Integer auSetVol) {
        this.auSetVol = auSetVol;
    }

    public Integer getAuSetVoiPer() {
        return auSetVoiPer;
    }

    public void setAuSetVoiPer(Integer auSetVoiPer) {
        this.auSetVoiPer = auSetVoiPer;
    }

    public Integer getAuSetSpd() {
        return auSetSpd;
    }

    public void setAuSetSpd(Integer auSetSpd) {
        this.auSetSpd = auSetSpd;
    }

    public Integer getAuSetPit() {
        return auSetPit;
    }

    public void setAuSetPit(Integer auSetPit) {
        this.auSetPit = auSetPit;
    }

    @Override
    public String toString() {
        return "AudioConfig{" +
                "userID=" + userID +
                ", auSetVol=" + auSetVol +
                ", auSetVoiPer=" + auSetVoiPer +
                ", auSetSpd=" + auSetSpd +
                ", auSetPit=" + auSetPit +
                '}';
    }
}
