package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by wawawa
 * Date 2019/4/23 Time 16:41
 */


public class CinemaInfoVO implements Serializable {

    private String cinemaId;
    private String imgUrl;
    private String cinemaName;
    private String cinemaAddress;
    private String cinemaPhone;

    @Override
    public String toString() {
        return "CinemaInfoVO{" +
                "cinemaId='" + cinemaId + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaAddress='" + cinemaAddress + '\'' +
                ", cinemaPhone='" + cinemaPhone + '\'' +
                '}';
    }

    public String getCinemaId() {
        return cinemaId;
    }

    public void setCinemaId(String cinemaId) {
        this.cinemaId = cinemaId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getCinemaAddress() {
        return cinemaAddress;
    }

    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }

    public String getCinemaPhone() {
        return cinemaPhone;
    }

    public void setCinemaPhone(String cinemaPhone) {
        this.cinemaPhone = cinemaPhone;
    }
}

