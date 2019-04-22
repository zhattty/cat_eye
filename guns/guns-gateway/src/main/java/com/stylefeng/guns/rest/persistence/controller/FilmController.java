package com.stylefeng.guns.rest.persistence.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.BannerBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmBo;
import com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo.FilmIndexQueryVo;
import com.stylefeng.guns.rest.persistence.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;


/**
 * Created by ZhangYao
 * Date 2019/4/21 Time 15:57
 */
@RestController
@RequestMapping("/film")
public class FilmController {

    @Reference
    FilmService filmService;
    @RequestMapping("getIndex")
    public FilmIndexQueryVo getIndex(){
        FilmIndexQueryVo queryVo = new FilmIndexQueryVo();
        // 查找banner找不到直接报错返回status = 1   msg=查询失败，无banner可加载
        // 这里写死了banner的id
        Integer[] ids = new Integer[]{2, 3, 4, 5, 6};
        List<BannerBo> bannsers = filmService.listValidBannerByIds(ids);
        if (bannsers.size() == 0){
            queryVo.setStatus(1);
            queryVo.setMsg("查询失败，无banner可加载");
            return queryVo;
        }
        HashMap<String, Object> dataMap = new HashMap<>(6);
        dataMap.put("banners",bannsers);
        // 查找其他所需数据，若无异常   status = 0
        try {
            queryVo.setStatus(0);
            // hotFilms
            HashMap<String, Object> hotFilms = new HashMap<>();
            List<FilmBo> filmInfo = filmService.listHotFilms();
            int filmNum = filmInfo.size();
            hotFilms.put("filmInfo", filmInfo);
            hotFilms.put("filmNum", filmNum);
            dataMap.put("hotFilms", hotFilms);
            // soonFilms
            HashMap<String, Object> soonFilms = new HashMap<>();
            filmInfo = filmService.listSoonFilms();
            filmNum = filmInfo.size();
            soonFilms.put("filmInfo", filmInfo);
            soonFilms.put("filmNum", filmNum);
            dataMap.put("soonFilms", soonFilms);
            // boxRanking
            List<FilmBo> boxRanking = filmService.listTop10Box(10);
            dataMap.put("boxRanking", boxRanking);
            // expectRanking
            List<FilmBo> expectRanking = filmService.listTopExpect(10);
            dataMap.put("expectRanking", expectRanking);
            // top100
            List<FilmBo> top100 = filmService.listTop100Limit(10);
            dataMap.put("top100",top100);
            queryVo.setData(dataMap);
        }catch (Exception e){
            // 若发生异常，              status = 999 msg=系统出现异常，请联系管理员
            e.printStackTrace();
            queryVo.setStatus(999);
            queryVo.setMsg("系统出现异常，请联系管理员");
            return queryVo;
        }
        return queryVo;
    }

}
