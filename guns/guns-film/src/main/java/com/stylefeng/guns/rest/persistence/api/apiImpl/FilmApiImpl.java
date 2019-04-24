package com.stylefeng.guns.rest.persistence.api.apiImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.api.filmApi.FilmApi;
import com.stylefeng.guns.rest.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmDetailBo;
import com.stylefeng.guns.rest.persistence.model.requestVo.filmRequestVo.FilmSearchRequestVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:13
 */
@Component
@Service(interfaceClass = FilmApi.class)
public class FilmApiImpl implements FilmApi {
    @Autowired
    MtimeFilmTMapper filmTMapper;
    @Override
    public List<FilmBo> listHotFilms() {
        return filmTMapper.listHotFilms();
    }

    @Override
    public List<FilmBo> listSoonFilms() {
        return filmTMapper.listSoonFilms();
    }

    @Override
    public List<FilmBo> listTop10Box(int topNum) {
        return filmTMapper.listTop10Box(topNum);
    }

    @Override
    public List<FilmBo> listTopExpect(int topNum) {
        return filmTMapper.listTopExpect(topNum);
    }

    @Override
    public List<FilmBo> listTop100Limit(int limit) {
        return filmTMapper.listTop100Limt(limit);
    }

    @Override
    public Page<FilmBo> listPageFilmsWithConditions(Page<FilmBo> page, FilmSearchRequestVo filmSearchRequestVo) {
        return page.setRecords(filmTMapper.listPageFilmsWithConditions(page, filmSearchRequestVo));
    }

    @Override
    public FilmDetailBo getFilmDetailBo(int searchType, String searchParam) {
        return filmTMapper.getFilmDetailBo(searchType, searchParam);
    }
}
