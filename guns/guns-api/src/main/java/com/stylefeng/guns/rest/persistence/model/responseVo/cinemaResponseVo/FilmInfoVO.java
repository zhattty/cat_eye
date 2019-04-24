package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/23 Time 16:47
 */

public class FilmInfoVO implements Serializable {

    private String filmId;
    private String filmName;
    private String filmLength;
    private String filmType;
    private String filmCats;
    private String actors;
    private String imgAddress;
    private List<FilmIFieldVO> list;

    @Override
    public String toString() {
        return "FilmInfoVO{" +
                "filmId='" + filmId + '\'' +
                ", filmName='" + filmName + '\'' +
                ", filmLength='" + filmLength + '\'' +
                ", filmType='" + filmType + '\'' +
                ", filmCats='" + filmCats + '\'' +
                ", actors='" + actors + '\'' +
                ", imgAddress='" + imgAddress + '\'' +
                ", list=" + list +
                '}';
    }

    public String getFilmId() {
        return filmId;
    }

    public void setFilmId(String filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    public String getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(String filmLength) {
        this.filmLength = filmLength;
    }

    public String getFilmType() {
        return filmType;
    }

    public void setFilmType(String filmType) {
        this.filmType = filmType;
    }

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImgAddress() {
        return imgAddress;
    }

    public void setImgAddress(String imgAddress) {
        this.imgAddress = imgAddress;
    }

    public List<FilmIFieldVO> getList() {
        return list;
    }

    public void setList(List<FilmIFieldVO> list) {
        this.list = list;
    }
}
