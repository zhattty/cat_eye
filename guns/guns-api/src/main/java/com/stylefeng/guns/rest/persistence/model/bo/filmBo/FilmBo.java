package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZhangYao
 * Date 2019/4/22 Time 17:32
 */
public class FilmBo implements Serializable {
    int filmId;
    int filmType;
    String imgAddress;
    String filmName;
    double filmScore;
    int expectNum;
    Date showTime;
    double score;
    int boxNum;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getFilmType() {
        return filmType;
    }

    public void setFilmType(int filmType) {
        this.filmType = filmType;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public double getFilmScore() {
        return filmScore;
    }

    public void setFilmScore(double filmScore) {
        this.filmScore = filmScore;
    }

    public int getExpectNum() {
        return expectNum;
    }

    public void setExpectNum(int expectNum) {
        this.expectNum = expectNum;
    }

    public Date getShowTime() {
        return showTime;
    }

    public void setShowTime(Date showTime) {
        this.showTime = showTime;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(int boxNum) {
        this.boxNum = boxNum;
    }
}
