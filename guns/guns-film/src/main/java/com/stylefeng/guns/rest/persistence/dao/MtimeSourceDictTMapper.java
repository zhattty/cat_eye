package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeSourceDictT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.SourceBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 区域信息表 Mapper 接口
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
public interface MtimeSourceDictTMapper extends BaseMapper<MtimeSourceDictT> {

    List<SourceBo> listAllSource();

    SourceBo selectSourceById(int sourceId);

    String[] listSourceNames(@Param("ids") String[] ids);
}
