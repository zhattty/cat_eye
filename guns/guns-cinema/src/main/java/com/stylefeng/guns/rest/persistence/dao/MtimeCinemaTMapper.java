package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.CinemaVO;
import com.stylefeng.guns.rest.persistence.model.requestVo.cinemaRequestVo.GetCinemasRequestVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.CinemaInfoVO;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.FilmInfoVO;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.HallInfoVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 影院信息表 Mapper 接口
 * </p>
 *
 * @author jack
 * @since 2019-04-22
 */
public interface MtimeCinemaTMapper  {
    CinemaInfoVO queryACinema(int cinemaId);
    List<FilmInfoVO> queryCinemaField(int cinemaId);
    FilmInfoVO queryFilmInfo(int cinemaId, int fieldId);
    HallInfoVO queryHallInfo(int fieldId);
    List<CinemaVO> queryCinemasByPage(@Param("limit") int pageSize, @Param("offset") int offset, @Param("cinema") GetCinemasRequestVo getCinemasRequestVo);
}
