package com.stylefeng.guns.rest.persistence.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.api.CinemaServiceAPI;
import com.stylefeng.guns.rest.persistence.dao.MtimeCinemaTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeHallFilmInfoTMapper;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.CinemaInfoVO;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.FilmInfoVO;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.HallInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Service(interfaceClass = CinemaServiceAPI.class)
@Component
public class CinemaServiceAPIImpl implements CinemaServiceAPI {

    @Autowired
    MtimeCinemaTMapper mtimeCinemaTMapper;
    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;
    @Autowired
    MtimeHallFilmInfoTMapper mtimeHallFilmInfoTMapper;
    @Override
    public CinemaInfoVO getCinemaInfoVoById(int cinemaId) {
        CinemaInfoVO cinemaInfoVo = mtimeCinemaTMapper.queryACinema(cinemaId);
        return cinemaInfoVo;
    }

    @Override
    public List<FilmInfoVO> getFilmInfoVobyId(int cinemaId) {
        List<FilmInfoVO> filmInfoVos = mtimeCinemaTMapper.queryCinemaField(cinemaId);
        return filmInfoVos;
    }

    @Override
    public FilmInfoVO queryFilmInfo(int cinemaId, int fieldId) {
        FilmInfoVO filmInfoVo = mtimeCinemaTMapper.queryFilmInfo(cinemaId, fieldId);
        return filmInfoVo;
    }

    @Override
    public HallInfoVO queryHallInfo(int fieldId) {
        HallInfoVO hallInfoVo = mtimeCinemaTMapper.queryHallInfo(fieldId);
        //hallInfoVo.setSoldSeats("1,2,3,4,5,6");
        return hallInfoVo;
    }


}
