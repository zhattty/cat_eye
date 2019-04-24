package com.stylefeng.guns.rest.persistence.model.bo.cinemaBo;


/**
 * <p>
 * 影厅电影信息表
 * </p>
 *
 * @author jack
 * @since 2019-04-22
 */
public class MtimeHallFilmInfoT {


    /**
     * 主键编号
     */
    private Integer uuid;
    /**
     * 电影编号
     */
    private Integer filmId;
    /**
     * 电影名称
     */
    private String filmName;
    /**
     * 电影时长
     */
    private String filmLength;
    /**
     * 电影类型
     */
    private String filmCats;
    /**
     * 电影语言
     */
    private String filmLanguage;
    /**
     * 演员列表
     */
    private String actors;
    /**
     * 图片地址
     */
    private String imgAddress;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(Integer filmId) {
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

    public String getFilmCats() {
        return filmCats;
    }

    public void setFilmCats(String filmCats) {
        this.filmCats = filmCats;
    }

    public String getFilmLanguage() {
        return filmLanguage;
    }

    public void setFilmLanguage(String filmLanguage) {
        this.filmLanguage = filmLanguage;
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


    @Override
    public String toString() {
        return "MtimeHallFilmInfoT{" +
        "uuid=" + uuid +
        ", filmId=" + filmId +
        ", filmName=" + filmName +
        ", filmLength=" + filmLength +
        ", filmCats=" + filmCats +
        ", filmLanguage=" + filmLanguage +
        ", actors=" + actors +
        ", imgAddress=" + imgAddress +
        "}";
    }
}
