package com.stylefeng.guns.rest.persistence.service;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.*;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/22 Time 17:13
 */
public interface FilmService {
    List<BannerBo> listValidBannerByIds(Integer[] ids);

    List<FilmBo> listHotFilms();

    List<FilmBo> listSoonFilms();

    List<FilmBo> listTop10Box(int i);

    List<FilmBo> listTopExpect(int i);

    List<FilmBo> listTop100Limit(int i);

    List<SourceBo> listAllSource();

    SourceBo selectSourceById(int sourceId);

    List<CatBo> listAllCat();

    CatBo selectCatById(int catId);

    List<YearBo> listAllYear();

    YearBo selectYearById(int yearId);
}
