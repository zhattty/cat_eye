package com.stylefeng.guns.rest.persistence.api.cinemaApi;

import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.CinemaVO;
import com.stylefeng.guns.rest.persistence.model.requestVo.cinemaRequestVo.GetCinemasRequestVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.*;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/22 Time 21:01
 */

public interface CinemaApi {
    // 查询影院列表
    List<CinemaVO> getCinemas(int pageSize, int nowPage, GetCinemasRequestVo getCinemasRequestVo);


    // 根据条件获取品牌列表
    List<BrandVO> getBrands(int brandId);

    // 获取行政区域
    List<AreaVO> getAreas(int areaId);

    // 获取影厅类型列表
    List<HallTypeVO> getHallTypes(String hallType);

    // 根据影院编号获取影院信息
    CinemaInfoVO getCinemaInfoByCinemaId(int cinemaId);

    // 根据影院标号获取所有电影的信息和所对应的放映场次信息，
    List<FilmInfoVO> getFilmInfoByCinemaId(int cinemaId);

    // 根据放映场次ID获取放映信息
    List<FilmIFieldVO> getFilmInfoFieldId(int fieldId);

    // 根据电影院编号查询电影院
    List<CinemaInfoVO> getCinemaByCinemaId(int cinemaId);

    // 根据放映场次获取放映厅信息
    List<HallInfoVO> getHallByFieldId(int fieldId);
}
