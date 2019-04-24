package com.stylefeng.guns.rest.persistence.api.apiImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.stylefeng.guns.rest.persistence.api.filmApi.SourceApi;
import com.stylefeng.guns.rest.persistence.dao.MtimeSourceDictTMapper;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.SourceBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:17
 */
@Component
@Service(interfaceClass = SourceApi.class)
public class SourceApiImpl implements SourceApi {
    @Autowired
    MtimeSourceDictTMapper mtimeSourceDictTMapper;
    @Override
    public List<SourceBo> listAllSource() {
        return mtimeSourceDictTMapper.listAllSource();
    }

    @Override
    public SourceBo selectSourceById(int sourceId) {
        return mtimeSourceDictTMapper.selectSourceById(sourceId);
    }

    @Override
    public String[] listSourceNames(String[] areaIds) {
        return mtimeSourceDictTMapper.listSourceNames(areaIds);
    }
}
