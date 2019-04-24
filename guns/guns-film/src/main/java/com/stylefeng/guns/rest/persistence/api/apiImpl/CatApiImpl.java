package com.stylefeng.guns.rest.persistence.api.apiImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.api.filmApi.CatApi;
import com.stylefeng.guns.rest.persistence.dao.MtimeCatDictTMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.CatBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:19
 */
@Component
@Service(interfaceClass = CatApi.class)
public class CatApiImpl implements CatApi {
    @Autowired
    MtimeCatDictTMapper mtimeCatDictTMapper;

    @Override
    public List<CatBo> listAllCat() {
        return mtimeCatDictTMapper.listAllCat();
    }

    @Override
    public CatBo selectCatById(int catId) {
        return mtimeCatDictTMapper.selectCatById();
    }

    @Override
    public String[] listCatNameByIds(String[] catIds) {
        return mtimeCatDictTMapper.listCatNameByIds(catIds);
    }
}
