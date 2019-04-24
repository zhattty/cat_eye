package com.stylefeng.guns.rest.persistence.api.apiImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.api.filmApi.ActorApi;
import com.stylefeng.guns.rest.persistence.dao.MtimeActorTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeFilmActorTMapper;
import com.stylefeng.guns.rest.persistence.model.MtimeFilmActorT;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.ActorBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.DirectorBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/24 Time 11:13
 */
@Component
@Service(interfaceClass = ActorApi.class)
public class ActorApiImpl implements ActorApi {
    @Autowired
    MtimeActorTMapper actorTMapper;

    @Autowired
    MtimeFilmActorTMapper filmActorTMapper;
    @Override
    public DirectorBo selectDirectorById(int directId) {
        return actorTMapper.selectDirectorById(directId);
    }

    @Override
    public List<ActorBo> selectActorsByFilmId(int filmId) {
        return filmActorTMapper.listActorsByFilmId(filmId);
    }
}
