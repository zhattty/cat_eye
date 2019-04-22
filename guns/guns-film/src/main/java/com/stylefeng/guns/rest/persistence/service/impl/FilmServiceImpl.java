package com.stylefeng.guns.rest.persistence.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.BannerBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmBo;
import com.stylefeng.guns.rest.persistence.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/22 Time 17:14
 */
@Component
@Service(interfaceClass = FilmService.class)
public class FilmServiceImpl implements FilmService{
    @Autowired
    IMtimeFilmTService iMtimeFilmTService;

    @Autowired
    IMtimeBannerTService iMtimeBannerTService;

    @Autowired
    IMtimeCatDictTService iMtimeCatDictTService;

    @Autowired
    IMtimeFilmInfoTService iMtimeFilmInfoTService;

    @Autowired
    IMtimeActorTService iMtimeActorTService;

    @Autowired
    IMtimeSourceDictTService iMtimeSourceDictTService;

    @Autowired
    IMtimeYearDictTService iMtimeYearDictTService;


    @Override
    public List<BannerBo> listValidBannerByIds(Integer[] ids) {
        return iMtimeBannerTService.listValidBannerByIds(ids);
    }

    @Override
    public List<FilmBo> listHotFilms() {
        return iMtimeFilmTService.listHotFilms();
    }

    @Override
    public List<FilmBo> listSoonFilms() {
        return iMtimeFilmTService.listSoonFilms();
    }

    @Override
    public List<FilmBo> listTop10Box(int i) {
        return iMtimeFilmTService.listTop10Box(i);
    }

    @Override
    public List<FilmBo> listTopExpect(int i) {
        return  iMtimeFilmTService.listTopExpect(i);
    }

    @Override
    public List<FilmBo> listTop100Limit(int i) {
        return iMtimeFilmTService.listTop100Limit(i);
    }
}
