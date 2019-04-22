package com.stylefeng.guns.rest.persistence.service.impl;

import com.stylefeng.guns.rest.persistence.model.MtimeFilmT;
import com.stylefeng.guns.rest.persistence.dao.MtimeFilmTMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmBo;
import com.stylefeng.guns.rest.persistence.service.IMtimeFilmTService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 影片主表 服务实现类
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
@Service
public class MtimeFilmTServiceImpl extends ServiceImpl<MtimeFilmTMapper, MtimeFilmT> implements IMtimeFilmTService {
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


}
