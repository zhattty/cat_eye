package com.stylefeng.guns.rest.persistence.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.api.filmApi.*;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.*;
import com.stylefeng.guns.rest.persistence.model.requestVo.filmRequestVo.FilmSearchRequestVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo.FilmDetailQueryVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo.FilmDetailVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo.FilmQueryVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo.FilmSearchQueryVo;
import com.stylefeng.guns.rest.persistence.utils.StringArrayConcatUtil;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Source;
import java.text.SimpleDateFormat;
import java.util.*;


/**
 * Created by ZhangYao
 * Date 2019/4/21 Time 15:57
 */
@RestController
@RequestMapping("/film")
public class FilmController {

    @Reference
    FilmApi filmApi;

    @Reference
    BannerApi bannerApi;

    @Reference
    YearApi yearApi;

    @Reference
    SourceApi sourceApi;

    @Reference
    CatApi catApi;

    @Reference
    ActorApi actorApi;

    @RequestMapping(value = "/getIndex", method = RequestMethod.GET)
    public FilmQueryVo getIndex(){
        FilmQueryVo queryVo = new FilmQueryVo();
        queryVo.setImgPre("http://img.meetingshop.cn/");
        // 查找banner找不到直接报错返回status = 1   msg=查询失败，无banner可加载
        // 这里写死了banner的id
        Integer[] ids = new Integer[]{2, 3, 4, 5, 6};
        List<BannerBo> bannsers = bannerApi.listValidBannerByIds(ids);
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
            List<FilmBo> filmInfo = filmApi.listHotFilms();
            int filmNum = filmInfo.size();
            hotFilms.put("filmInfo", filmInfo);
            hotFilms.put("filmNum", filmNum);
            dataMap.put("hotFilms", hotFilms);
            // soonFilms
            HashMap<String, Object> soonFilms = new HashMap<>();
            filmInfo = filmApi.listSoonFilms();
            filmNum = filmInfo.size();
            soonFilms.put("filmInfo", filmInfo);
            soonFilms.put("filmNum", filmNum);
            dataMap.put("soonFilms", soonFilms);
            // boxRanking
            List<FilmBo> boxRanking = filmApi.listTop10Box(10);
            dataMap.put("boxRanking", boxRanking);
            // expectRanking
            List<FilmBo> expectRanking = filmApi.listTopExpect(10);
            dataMap.put("expectRanking", expectRanking);
            // top100
            List<FilmBo> top100 = filmApi.listTop100Limit(10);
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

    @RequestMapping(value = "/getConditionList", method = RequestMethod.GET)
    // 暂时不确定传来参数的形式
    public FilmQueryVo getConditionList(@RequestParam( name = "catId", defaultValue = "99") int catId,
                                        @RequestParam( name = "yearID", defaultValue = "99") int yearId,
                                        @RequestParam( name = "sourceId", defaultValue = "99") int sourceId){
        FilmQueryVo filmQueryVo = new FilmQueryVo();
        filmQueryVo.setStatus(1);
        filmQueryVo.setMsg("查询失败，无条件可加载");
        try {
            // 查询sourceInfo
            HashMap<String, Object> dataMap = new HashMap<>();
            List<SourceBo> sourceInfo = null;
            if (sourceId == 99) {
                sourceInfo = sourceApi.listAllSource();
                if (sourceInfo.size() == 0){
                    return filmQueryVo;
                }
            } else {
                sourceInfo = new ArrayList<SourceBo>();
                SourceBo sourceBo = sourceApi.selectSourceById(sourceId);
                if (sourceBo == null){
                    return filmQueryVo;
                }
                sourceInfo.add(sourceBo);
            }
            dataMap.put("sourceInfo", sourceInfo);
            // 查询catInfo
            List<CatBo> catInfo = null;
            if (catId == 99) {
                catInfo = catApi.listAllCat();
                if (catInfo.size() == 0){
                    return filmQueryVo;
                }
            } else {
                catInfo = new ArrayList<CatBo>();
                CatBo catBo = catApi.selectCatById(catId);
                if (catBo == null){
                    return filmQueryVo;
                }
                catInfo.add(catBo);
            }
            dataMap.put("catInfo", catInfo);

            // 查询yearInfo
            List<YearBo> yearInfo = null;
            if (yearId == 99) {
                yearInfo = yearApi.listAllYear();
                if (yearInfo.size() == 0){
                    return filmQueryVo;
                }
            } else {
                yearInfo = new ArrayList<YearBo>();
                YearBo yearBo = yearApi.selectYearById(yearId);
                if (yearBo == null){
                    return filmQueryVo;
                }
                yearInfo.add(yearBo);
            }
            dataMap.put("yearInfo", yearInfo);
            filmQueryVo.setData(dataMap);
        }catch (Exception e){
            e.printStackTrace();
            filmQueryVo.setStatus(999);
            filmQueryVo.setMsg("系统出现异常，请联系管理员");
            return filmQueryVo;
        }
        filmQueryVo.setStatus(0);
        filmQueryVo.setMsg("");
        return filmQueryVo;
    }

    @RequestMapping(value = "/getFilms", method = RequestMethod.GET)
    public FilmSearchQueryVo getFilms(FilmSearchRequestVo filmSearchRequestVo){
        FilmSearchQueryVo queryVo = new FilmSearchQueryVo();
        Page<FilmBo> film = null;
        try {
            // 查询分页内容
            Page<FilmBo> page =new Page<>();
            page.setCurrent(filmSearchRequestVo.getNowPage());
            page.setSize(filmSearchRequestVo.getPageSize());
            film = filmApi.listPageFilmsWithConditions(page, filmSearchRequestVo);
            List<FilmBo> data = film.getRecords();
            if (data.size() == 0){
                // 没有任何查询结果
                queryVo.setStatus(1);
                queryVo.setMsg("没有符合条件的电影");
                return queryVo;
            }
            queryVo.setData(data);
        }catch (Exception e){
            // 查询出现异常
            e.printStackTrace();
            queryVo.setStatus(999);
            queryVo.setMsg("系统出现异常，请联系管理员");
            return queryVo;
        }
        queryVo.setStatus(0);
        // TODO
        queryVo.setImgPre("http://img.meetingshop.cn/");
        queryVo.setNowPage(film.getCurrent());
        queryVo.setTotalPage((int)film.getTotal());
        return queryVo;
    }

    @RequestMapping("/films/{searchParam}")
    public FilmDetailQueryVo getDetailFilmInf(int searchType, @PathVariable("searchParam") String searchParam){
        FilmDetailQueryVo queryVo = new FilmDetailQueryVo();
        try {
            // 查询出来的结果还要通过转化来变成vo
            // info 1 2 3 4 和 外层的 imgs
            FilmDetailBo detailBo = filmApi.getFilmDetailBo(searchType, searchParam);
            FilmDetailVo detailVo = buildFromDetailBo(detailBo);

            queryVo.setData(detailVo);
//            String filmImgs = detailBo.getFilmImgs();
//            Map<String , String> imgs = transferImgs(filmImgs);
//            queryVo.setImgs(imgs);
            queryVo.setFilmId(detailBo.getFilmId());
        }catch (Exception e){
            e.printStackTrace();
            queryVo.setStatus(999);
            queryVo.setMsg("发生异常请联系管理员");
            return queryVo;
        }
        queryVo.setStatus(0);
        queryVo.setImgPre("https://cat-eye.oss-cn-shenzhen.aliyuncs.com/");
        return queryVo;
    }

    private Map<String, String> transferImgs(String filmImgs) throws Exception {
        if (filmImgs == null) {
            throw new Exception("filmImgs cannot be null");
        }
        HashMap<String, String> map = new HashMap<>();
        String[] split = filmImgs.split(",");
        for (int i = 0; i <split.length; i++) {
            if (i == 0){
                map.put("mainImg",split[i]);
            }else {
                map.put("img0"+i,split[i]);
            }
        }
        return map;
    }

    private FilmDetailVo buildFromDetailBo(FilmDetailBo bo) throws Exception {
        FilmDetailVo vo = new FilmDetailVo();
        vo.setFilmName(bo.getFilmName());
        vo.setFilmEnName(bo.getFilmEnName());
        vo.setImgAddress(bo.getImgAddress());
        vo.setScore(bo.getScore());
        vo.setScoreNum(bo.getScoreNum());
        vo.setTotalBox(bo.getTotalBox());
        
        // info1
        String filmCats = bo.getFilmCats();
        String[] catIds = filmCats.split("#");
        String[] catNames = catApi.listCatNameByIds(catIds);
        vo.setInfo01(StringArrayConcatUtil.concatWithSperator(catNames,","));

        // info2
        String filmArea = bo.getFilmArea();
        String[] areaIds = filmArea.split("#");
        String[] sourceNames = sourceApi.listSourceNames(areaIds);
        String info02 = StringArrayConcatUtil.concatWithSperator(sourceNames,",") + "/" + bo.getFilmLength();
        vo.setInfo02(info02);

        // info3
        Date filmTime = bo.getFilmTime();
        int filmSource = bo.getFilmSource();
        SourceBo sourceBo = sourceApi.selectSourceById(filmSource);
        String sourceName = sourceBo.getSourceName();
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd");
        String date = format.format(bo.getFilmTime());
        String info03 = date + "/ " + sourceName;
        vo.setInfo03(info03);

        // info4
        DirectorBo director = actorApi.selectDirectorById(bo.getDirectId());
        List<ActorBo> actors = actorApi.selectActorsByFilmId(bo.getFilmId());
        // System.out.println(actors);
        InfoBo info04 = bo.getInfo04();
        ActorsBo actorsBo = new ActorsBo();
        actorsBo.setDirector(director);
        actorsBo.setActors(actors);
        info04.setActors(actorsBo);
        Map<String, String> map = transferImgs(bo.getFilmImgs());
        info04.setImgVO(map);
        info04.setFilmId(bo.getFilmId());
        vo.setInfo04(info04);
        return vo;
    }
}
