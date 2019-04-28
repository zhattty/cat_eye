package com.stylefeng.guns.rest.persistence.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.persistence.api.CinemaServiceAPI;
import com.stylefeng.guns.rest.persistence.api.cinemaApi.CinemaApi;
import com.stylefeng.guns.rest.persistence.api.orderApi.OrderApi;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.CinemaVO;
import com.stylefeng.guns.rest.persistence.model.requestVo.cinemaRequestVo.GetCinemasRequestVo;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo.*;
import com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.HallInfoVO;
import com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo.FilmIndexQueryVo;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @Reference
    CinemaServiceAPI cinemaServiceAPI;

    @Reference
    OrderApi orderApi;

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
            getCinemasResponseVo.setData(list);
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
    public HashMap queryCinemaDetail(@RequestParam("cinemaId") int cinemaId){
        try {
            com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.CinemaInfoVO cinemaInfo = cinemaServiceAPI.getCinemaInfoVoById(cinemaId);
            List<com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.FilmInfoVO> filmInfoList = cinemaServiceAPI.getFilmInfoVobyId(cinemaId);
            HashMap<String, Object> map1 = new HashMap<>();
            HashMap<String, Object> map2 = new HashMap<>();

            if (cinemaInfo != null) {
                map2.put("cinemaInfo", cinemaInfo);
                map2.put("filmList",filmInfoList);
                map1.put("status", 0);
                map1.put("imgPre", "http://img.meetingshop.cn/");
                map1.put("data", map2);
                return map1;
            } else {
                map1.put("status", 1);
                map1.put("msg", "影院信息查询失败");
                return map1;
            }
        }catch (Exception e){
            HashMap<String, Object> map = new HashMap<>(2);
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
            e.printStackTrace();
            Map<String, Object> map = new HashMap<>(2);
            map.put("status",999);
            map.put("msg","发生未知错误请联系管理员");
            return map;
        }

    }


    @RequestMapping(value = "getFieldInfo",method = RequestMethod.POST)
    public HashMap queryFilmFieldDetail(@RequestParam("cinemaId") int cinemaId,@RequestParam("fieldId") int fieldId){
        try {
            com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.FilmInfoVO filmInfo = cinemaServiceAPI.queryFilmInfo(cinemaId, fieldId);
            com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo.CinemaInfoVO cinemaInfo = cinemaServiceAPI.getCinemaInfoVoById(cinemaId);
            HallInfoVO hallInfo = cinemaServiceAPI.queryHallInfo(fieldId);
            String soldSeats = orderApi.getSoldSeatsByFieldId(fieldId);
            hallInfo.setSoldSeats(soldSeats);
            HashMap<String, Object> map1 = new HashMap();
            HashMap<String, Object> map2 = new HashMap();
            if (filmInfo != null && cinemaInfo != null && hallInfo != null) {

                map2.put("filmInfo", filmInfo);
                map2.put("cinemaInfo", cinemaInfo);
                map2.put("hallInfo", hallInfo);

                map1.put("status", 0);
                map1.put("imgPre", "http://img.meetingshop.cn/");
                map1.put("data", map2);
                return map1;

            } else {
                map1.put("status", 1);
                map1.put("msg", "影院信息查询失败");
                return map1;
            }
        }catch (Exception e){
            HashMap<String, Object> map3 = new HashMap<>(2);
            map3.put("status",999);
            map3.put("msg","发生未知错误请联系管理员");
            return map3;
        }


    }


}
