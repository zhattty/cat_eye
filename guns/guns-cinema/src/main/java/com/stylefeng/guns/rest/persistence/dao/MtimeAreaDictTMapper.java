package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeAreaDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.AreaVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 地域信息表 Mapper 接口
 * </p>
 *
 * @author jack
 * @since 2019-04-22
 */
public interface MtimeAreaDictTMapper extends BaseMapper<MtimeAreaDictT> {

    List<AreaVO> selectByAreaId(@Param("areaId") int areaId);
}
