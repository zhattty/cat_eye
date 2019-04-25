package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo;

import java.util.List;


public class CinemaFieldsResponseVO {
    private CinemaInfoVO cinemaInfoVo;
    private List<FilmInfoVO> filmList;

    public CinemaInfoVO getCinemaInfoVo() {
        return cinemaInfoVo;
    }

    public void setCinemaInfoVo(CinemaInfoVO cinemaInfoVo) {
        this.cinemaInfoVo = cinemaInfoVo;
    }

    public List<FilmInfoVO> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<FilmInfoVO> filmList) {
        this.filmList = filmList;
    }
}
