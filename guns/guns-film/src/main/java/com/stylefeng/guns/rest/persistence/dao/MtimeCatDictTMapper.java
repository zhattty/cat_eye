package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeCatDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.CatBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 类型信息表 Mapper 接口
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
public interface MtimeCatDictTMapper extends BaseMapper<MtimeCatDictT> {

    List<CatBo> listAllCat();

    CatBo selectCatById();

    String[] listCatNameByIds(@Param("ids") String[] catIds);
}
