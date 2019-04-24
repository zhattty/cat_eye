package com.stylefeng.guns.rest.persistence.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.api.cinemaApi.CinemaApi;
import com.stylefeng.guns.rest.persistence.dao.*;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.CinemaVO;
import com.stylefeng.guns.rest.persistence.model.requestVo.cinemaRequestVo.GetCinemasRequestVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by wawawa
 * Date 2019/4/22 Time 21:13
 */
@Component
@Service(interfaceClass = CinemaApi.class)
public class CinemaServiceImpl implements CinemaApi {

    @Autowired
    MtimeCinemaTMapper cinemaTMapper;

    @Autowired
    MtimeHallDictTMapper hallDictTMapper;

    @Autowired
    MtimeFieldTMapper fieldTMapper;

    @Autowired
    MtimeHallFilmInfoTMapper hallFilmInfoTMapper;

    @Autowired
    MtimeAreaDictTMapper areaDictTMapper;

    @Autowired
    MtimeBrandDictTMapper brandDictTMapper;


    @Override
    public List<CinemaVO> getCinemas(int pageSize, int nowPage, GetCinemasRequestVo getCinemasRequestVo) {
      /*  Page<CinemaVO> page = new Page<>(nowPage, pageSize);
        page.setRecords(cinemaTMapper.queryCinemasByPage(page,getCinemasRequestVo));*/
        return cinemaTMapper.queryCinemasByPage(pageSize,(nowPage-1)*pageSize,getCinemasRequestVo);
    }

    @Override
    public List<BrandVO> getBrands(int brandId) {
        List<BrandVO> brandVOList = brandDictTMapper.selectByBrandId(brandId);
        brandVOList.get(brandVOList.size()-1).setActive(true);
        return brandVOList;
    }

    @Override
    public List<AreaVO> getAreas(int areaId) {
        List<AreaVO> areaVOS = areaDictTMapper.selectByAreaId(areaId);
        areaVOS.get(areaVOS.size()-1).setActive(true);
        return areaVOS;
    }

    @Override
    public List<HallTypeVO> getHallTypes(String  hallType) {
        List<HallTypeVO> hallTypeVOList = hallDictTMapper.selectByHallType(Integer.valueOf(hallType));
        hallTypeVOList.get(hallTypeVOList.size()-1).setActive(true);
        return hallTypeVOList;
    }

    @Override
    public CinemaInfoVO getCinemaInfoByCinemaId(int cinemaId) {
        return null;
    }

    @Override
    public List<FilmInfoVO> getFilmInfoByCinemaId(int cinemaId) {
        return null;
    }

    @Override
    public List<FilmIFieldVO> getFilmInfoFieldId(int fieldId) {
        return null;
    }

    @Override
    public List<CinemaInfoVO> getCinemaByCinemaId(int cinemaId) {
        return null;
    }

    @Override
    public List<HallInfoVO> getHallByFieldId(int fieldId) {
        return null;
    }
}
