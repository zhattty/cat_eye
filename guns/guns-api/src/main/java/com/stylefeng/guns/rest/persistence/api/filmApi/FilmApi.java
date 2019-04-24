package com.stylefeng.guns.rest.persistence.api.filmApi;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmDetailBo;
import com.stylefeng.guns.rest.persistence.model.requestVo.filmRequestVo.FilmSearchRequestVo;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:03
 */
public interface FilmApi {
    List<FilmBo> listHotFilms();

    List<FilmBo> listSoonFilms();

    List<FilmBo> listTop10Box(int i);

    List<FilmBo> listTopExpect(int i);

    List<FilmBo> listTop100Limit(int i);

    Page<FilmBo> listPageFilmsWithConditions(Page<FilmBo> page, FilmSearchRequestVo filmSearchRequestVo);

    FilmDetailBo getFilmDetailBo(int searchType, String searchParam);
}
