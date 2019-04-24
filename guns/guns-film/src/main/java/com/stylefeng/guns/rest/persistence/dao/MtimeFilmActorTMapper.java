package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeFilmActorT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.ActorBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.DirectorBo;

import java.util.List;

/**
 * <p>
 * 影片与演员映射表 Mapper 接口
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-24
 */
public interface MtimeFilmActorTMapper extends BaseMapper<MtimeFilmActorT> {

    List<ActorBo> listActorsByFilmId(int filmId);
}
