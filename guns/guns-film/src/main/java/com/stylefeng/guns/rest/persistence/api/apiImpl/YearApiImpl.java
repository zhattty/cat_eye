package com.stylefeng.guns.rest.persistence.api.apiImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.api.filmApi.YearApi;
import com.stylefeng.guns.rest.persistence.dao.MtimeYearDictTMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.YearBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:21
 */
@Component
@Service(interfaceClass = YearApi.class)
public class YearApiImpl implements YearApi {
    @Autowired
    MtimeYearDictTMapper mtimeYearDictTMapper;
    @Override
    public List<YearBo> listAllYear() {
        return mtimeYearDictTMapper.listAllYear();
    }

    @Override
    public YearBo selectYearById(int yearId) {
        return mtimeYearDictTMapper.selectYearById(yearId);
    }
}
