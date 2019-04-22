package com.stylefeng.guns.rest.persistence.service;

import com.stylefeng.guns.rest.persistence.model.MtimeBannerT;
import com.baomidou.mybatisplus.service.IService;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.BannerBo;

import java.util.List;

/**
 * <p>
 * banner信息表 服务类
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
public interface IMtimeBannerTService extends IService<MtimeBannerT> {
    List<BannerBo> listValidBannerByIds(Integer[] ids);
}
