package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeBrandDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.BrandVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 品牌信息表 Mapper 接口
 * </p>
 *
 * @author jack
 * @since 2019-04-22
 */
public interface MtimeBrandDictTMapper extends BaseMapper<MtimeBrandDictT> {

    List<BrandVO> selectByBrandId(@Param("brandId") int brandId);
}
