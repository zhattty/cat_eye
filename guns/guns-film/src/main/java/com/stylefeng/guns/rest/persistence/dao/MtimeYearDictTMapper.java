package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeYearDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.YearBo;

import java.util.List;

/**
 * <p>
 * 年代信息表 Mapper 接口
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
public interface MtimeYearDictTMapper extends BaseMapper<MtimeYearDictT> {

    List<YearBo> listAllYear();

    YearBo selectYearById(int yearId);
}
