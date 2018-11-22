package com.bonc.domain;


import lombok.*;

/**
 * Created by 王小浪 on 2018/9/7.
 */
@lombok.Data
public class TalkingData {
    private  Integer talkId;
    private  String talkName;
    private  String talkDate;
    private  String talkDesc;
    private String talkType;
    private  String talkPro;

    public Integer getTalkId() {
        return talkId;
    }

    public void setTalkId(Integer talkId) {
        this.talkId = talkId;
    }

    public String getTalkName() {
        return talkName;
    }

    public void setTalkName(String talkName) {
        this.talkName = talkName;
    }

    public String getTalkData() {
        return talkDate;
    }

    public void setTalkData(String talkDate) {
        this.talkDate = talkDate;
    }

    public String getTalkDesc() {
        return talkDesc;
    }

    public void setTalkDesc(String talkDesc) {
        this.talkDesc = talkDesc;
    }

    public String getTalkType() {
        return talkType;
    }

    public void setTalkType(String talkType) {
        this.talkType = talkType;
    }

    public String getTalkPro() {
        return talkPro;
    }

    public void setTalkPro(String talkPro) {
        this.talkPro = talkPro;
    }
}
