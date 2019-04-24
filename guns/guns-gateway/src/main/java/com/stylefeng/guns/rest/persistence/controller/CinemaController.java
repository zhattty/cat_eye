package com.stylefeng.guns.rest.persistence.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.persistence.api.cinemaApi.CinemaApi;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.CinemaVO;
import com.stylefeng.guns.rest.persistence.model.requestVo.cinemaRequestVo.GetCinemasRequestVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.*;
import com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo.FilmIndexQueryVo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wawawa
 * Date 2019/4/22 Time 21:16
 */
@RestController
@RequestMapping("cinema")
public class CinemaController {

    @Reference
    CinemaApi cinemaService;

    @RequestMapping(value = "getCinemas",method = RequestMethod.GET)
    public Object getCinemas(Model model,
                                           @RequestParam(name = "brandId",defaultValue = "99")int brandId,
                                           @RequestParam(name = "hallType",defaultValue = "99")String hallType,
                                           @RequestParam(name = "districtId",defaultValue = "99")int districtId,
                                           @RequestParam(name = "pageSize",defaultValue = "12")int pageSize,
                                           @RequestParam(name = "nowPage",defaultValue = "1")int nowPage

                                           ) {

        GetCinemasResponseVo getCinemasResponseVo = new GetCinemasResponseVo();
        HashMap<String, Object> map = new HashMap<>();
        GetCinemasRequestVo getCinemasRequestVo = new GetCinemasRequestVo();
        getCinemasRequestVo.setBrandId(brandId);
        getCinemasRequestVo.setDistrictId(districtId);
        getCinemasRequestVo.setHallType(hallType);


        try {
            List<CinemaVO> list = cinemaService.getCinemas(pageSize, nowPage, getCinemasRequestVo);

            getCinemasResponseVo.setNowPage(nowPage);
            getCinemasResponseVo.setTotalPage(pageSize);
            getCinemasResponseVo.setStatus(0);
            map.put("data",list);
            getCinemasResponseVo.setMap(map);
            return list==null?new FilmIndexQueryVo(1,"影院信息查询失败"):getCinemasResponseVo;

        }catch (Exception e){
            e.printStackTrace();
            FilmIndexQueryVo vo = new FilmIndexQueryVo();
            vo.setStatus(999);
            vo.setMsg("联系管理员");
            return vo;
        }

    }


    @RequestMapping("getFields")
    public Map getFields(@RequestParam int  cinemaId){

        try {
            CinemaInfoVO cinemaInfoVO = cinemaService.getCinemaInfoByCinemaId(cinemaId);

            // 第二层map 用来封装cinemaInfo 和 filmList
            Map<String, Object> map = new HashMap<>();

            if (cinemaInfoVO == null) {
                // 数据库中没有找到相关的影院信息，返回
                map.put("status", 1);
                map.put("msg", "影院信息查询失败");
                return map;
            }

            List<FilmInfoVO> filmInfoVOList = cinemaService.getFilmInfoByCinemaId(cinemaId);

            // 遍历FilmInfoVO数组，根据filmInfoVO的filmId查找filmField
            for (FilmInfoVO filmInfoVO : filmInfoVOList) {

                List<FilmIFieldVO> fieldVO = cinemaService.getFilmInfoFieldId(Integer.valueOf(filmInfoVO.getFilmId()));
                if (fieldVO != null) {
                    filmInfoVO.setList(fieldVO);
                }
            }

            // 最底层的map 用来封装FilmFieldVO
            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("filmInfo", filmInfoVOList);


            // 找到信息，加进map中
            map.put("cinemaInfo", cinemaInfoVO);
            map.put("filmList", map1);

            // 第三层map用来封装返回的jason报文
            HashMap<String, Object> map2 = new HashMap<>();
            map2.put("status", 0);
            map2.put("imgPre", "http://img.meetingshop.cn/");
            map2.put("data", map1);
            return map2;
        }catch (Exception e){
            Map<String, Object> map = new HashMap<>();
            map.put("status",999);
            map.put("msg","发生未知错误请联系管理员");
            return map;
        }
    }

    @RequestMapping(value = "getCondition", method = RequestMethod.GET)
    public Map getCondition(@RequestParam(name = "brandId",defaultValue = "99")int brandId,
                            @RequestParam(name = "areaId",defaultValue = "99")int areaId,
                            @RequestParam(name = "areaId",defaultValue = "99")String  hallType
                            ){

        try {
            HashMap<String, Object> map1 = new HashMap<>(3);
            List<AreaVO> areaList = cinemaService.getAreas(areaId);
            List<BrandVO> brandList = cinemaService.getBrands(brandId);
            List<HallTypeVO> hallTypeList = cinemaService.getHallTypes(hallType);


            HashMap<String, Object> map2 = new HashMap<>(3);
            map2.put("areaList", areaList);
            map2.put("brandList", brandList);
            map2.put("halltypeList", hallTypeList);

            map1.put("status", 0);
            map1.put("data", map2);
            return map1;
        }catch (Exception e){
            Map<String, Object> map = new HashMap<>(2);
            map.put("status",999);
            map.put("msg","发生未知错误请联系管理员");
            return map;
        }

    }


    @RequestMapping(value = "getFieldInfo",method = RequestMethod.POST)
    public  Map getFieldInfo(@RequestParam("cinemaId") int cinemaId,@RequestParam("fieldId") int fieldId){

        try {
            HashMap<String, Object> map = new HashMap<>();

            // 根据cinemaId来查询所需要的电影院
            List<CinemaInfoVO> cinemaVOList = cinemaService.getCinemaByCinemaId(cinemaId);
            if(cinemaVOList==null){
                map.put("status",1);
                map.put("msg","影院信息查询失败");
                return map;
            }

            // 根据cinemaId来查询电影信息
            List<FilmInfoVO> filmInfo = cinemaService.getFilmInfoByCinemaId(cinemaId);

            if(filmInfo == null){
                map.put("status",1);
                map.put("msg","影院信息查询失败");
                return map;
            }

            // 根据fieldId来查询放映厅
            List<HallInfoVO> hallInfo= cinemaService.getHallByFieldId(fieldId);
            if(hallInfo == null){
                map.put("status",1);
                map.put("msg","影院信息查询失败");
                return map;
            }

            map.put("filmInfo",filmInfo);
            map.put("cinemaInfo", cinemaVOList);
            map.put("hallInfo", hallInfo);

            HashMap<String, Object> map1 = new HashMap<>();
            map1.put("status",0);
            map1.put("imgPre","http://img.meetingshop.cn/");
            map1.put("data",map);

            return map1;
        }catch (Exception e){
            Map<String, Object> map = new HashMap<>(2);
            map.put("status",999);
            map.put("msg","发生未知错误请联系管理员");
            return map;
        }

    }


}
