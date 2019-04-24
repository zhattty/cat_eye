package com.stylefeng.guns.rest.persistence.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.MtimeFilmT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmDetailBo;
import com.stylefeng.guns.rest.persistence.model.requestVo.filmRequestVo.FilmSearchRequestVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影片主表 Mapper 接口
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
public interface MtimeFilmTMapper extends BaseMapper<MtimeFilmT> {

    List<FilmBo> listHotFilms();

    List<FilmBo> listSoonFilms();

    List<FilmBo> listTop10Box(int topNum);

    List<FilmBo> listTopExpect(int topNum);

    List<FilmBo> listTop100Limt(int limit);

    List<FilmBo> listPageFilmsWithConditions(@Param("pg") Page<FilmBo> page, @Param("conditions")FilmSearchRequestVo filmSearchRequestVo);

    FilmDetailBo getFilmDetailBo(@Param("searchType") int searchType, @Param("searchParam") String searchParam);
}
