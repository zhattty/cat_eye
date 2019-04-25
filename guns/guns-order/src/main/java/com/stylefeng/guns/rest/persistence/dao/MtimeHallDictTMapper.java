package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeHallDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author Zhangyao
 * @since 2019-04-25
 */
public interface MtimeHallDictTMapper extends BaseMapper<MtimeHallDictT> {

    String selectHallSeatAddressByFieldId(String fieldId);
}
