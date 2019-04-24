package com.stylefeng.guns.rest.persistence.model.requestVo.filmRequestVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 11:49
 */
@Setter
@Getter
@ToString
public class FilmSearchRequestVo implements Serializable {
    // 1 正在热映 2 即将上映 3 经典影片
    private int showType = 1;

    // 1 按热门搜索 2 按时间搜索 3 按评价搜索
    private int sortId = 1;

    // 类型 默认99
    private int catId = 99;

    // 年代 默认99
    private int yearId = 99;

    // 区域 默认99
    private int sourceId = 99;

    //当前页面 默认1
    private int nowPage = 1;

    //每页显示条目 默认18
    private int pageSize = 18;

}
