package com.stylefeng.guns.rest.persistence.api.filmApi;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.ActorBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.DirectorBo;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/24 Time 11:12
 */
public interface ActorApi {
    DirectorBo selectDirectorById(int directId);

    List<ActorBo> selectActorsByFilmId(int filmId);
}
