package com.stylefeng.guns.rest.persistence.api.filmApi;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.CatBo;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:08
 */
public interface CatApi {
    List<CatBo> listAllCat();

    CatBo selectCatById(int catId);

    String[] listCatNameByIds(String[] catIds);
}
