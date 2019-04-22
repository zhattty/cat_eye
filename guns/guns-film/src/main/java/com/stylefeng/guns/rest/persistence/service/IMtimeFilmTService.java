package com.stylefeng.guns.rest.persistence.service;

import com.stylefeng.guns.rest.persistence.model.MtimeFilmT;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmBo;

import java.util.List;

/**
 * <p>
 * 影片主表 服务类
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
public interface IMtimeFilmTService extends IService<MtimeFilmT> {

    List<FilmBo> listHotFilms();

    List<FilmBo> listSoonFilms();

    List<FilmBo> listTop10Box(int topNum);

    List<FilmBo> listTopExpect(int topNum);

    List<FilmBo> listTop100Limit(int limit);
}
