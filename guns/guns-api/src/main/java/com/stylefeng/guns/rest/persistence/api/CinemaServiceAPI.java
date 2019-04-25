package com.stylefeng.guns.rest.persistence.api;

import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.CinemaInfoVO;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.FilmInfoVO;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.HallInfoVO;

import java.util.List;

public interface CinemaServiceAPI {
   CinemaInfoVO getCinemaInfoVoById(int cinemaId);
   List<FilmInfoVO> getFilmInfoVobyId(int cinemaId);
   FilmInfoVO queryFilmInfo(int cinemaId, int fieldId);
   HallInfoVO queryHallInfo(int fieldId);

}
