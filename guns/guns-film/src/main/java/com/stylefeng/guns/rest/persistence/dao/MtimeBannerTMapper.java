package com.stylefeng.guns.rest.persistence.dao;

import com.stylefeng.guns.rest.persistence.model.MtimeBannerT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.BannerBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * banner信息表 Mapper 接口
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
public interface MtimeBannerTMapper extends BaseMapper<MtimeBannerT> {
    /**
     * 根据ids 查找 is_valid 的 bannerList
     * @param ids banner 的 uuid 的 数组
     * @return banner 数组
     */
    List<BannerBo> listValidBannerByIds(@Param("ids") Integer[] ids);
}
