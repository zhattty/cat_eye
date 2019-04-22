package com.stylefeng.guns.rest.persistence.service.impl;

import com.stylefeng.guns.rest.persistence.model.MtimeBannerT;
import com.stylefeng.guns.rest.persistence.dao.MtimeBannerTMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.BannerBo;
import com.stylefeng.guns.rest.persistence.service.IMtimeBannerTService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * banner信息表 服务实现类
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
@Service
public class MtimeBannerTServiceImpl extends ServiceImpl<MtimeBannerTMapper, MtimeBannerT> implements IMtimeBannerTService {

    @Autowired
    MtimeBannerTMapper mtimeBannerTMapper;

    @Override
    public List<BannerBo> listValidBannerByIds(Integer[] ids) {
        return mtimeBannerTMapper.listValidBannerByIds(ids);
    }
}
