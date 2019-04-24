package com.stylefeng.guns.rest.persistence.api.apiImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.api.filmApi.BannerApi;
import com.stylefeng.guns.rest.persistence.dao.MtimeBannerTMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.BannerBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:15
 */
@Component
@Service(interfaceClass = BannerApi.class)
public class BannerApiImpl implements BannerApi {
    @Autowired
    MtimeBannerTMapper mtimeBannerTMapper;

    @Override
    public List<BannerBo> listValidBannerByIds(Integer[] ids) {
        return mtimeBannerTMapper.listValidBannerByIds(ids);
    }
}
