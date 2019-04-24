package com.stylefeng.guns.rest.persistence.api.filmApi;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.BannerBo;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:06
 */
public interface BannerApi {
    List<BannerBo> listValidBannerByIds(Integer[] ids);
}
