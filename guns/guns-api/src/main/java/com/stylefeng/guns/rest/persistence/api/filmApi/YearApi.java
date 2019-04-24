package com.stylefeng.guns.rest.persistence.api.filmApi;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.YearBo;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:08
 */
public interface YearApi {
    List<YearBo> listAllYear();

    YearBo selectYearById(int yearId);
}
