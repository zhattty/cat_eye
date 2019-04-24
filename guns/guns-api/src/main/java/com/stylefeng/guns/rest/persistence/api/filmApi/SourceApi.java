package com.stylefeng.guns.rest.persistence.api.filmApi;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.SourceBo;

import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:10
 */
public interface SourceApi {
    List<SourceBo> listAllSource();

    SourceBo selectSourceById(int sourceId);

    String[] listSourceNames(String[] areaIds);
}
