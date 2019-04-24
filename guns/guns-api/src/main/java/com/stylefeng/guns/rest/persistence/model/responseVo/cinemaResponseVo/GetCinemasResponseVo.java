package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by wawawa
 * Date 2019/4/22 Time 17:46
 */
public class GetCinemasResponseVo implements Serializable {

    private int status;
    private int nowPage;
    private int totalPage;
    private Map<String,Object> map;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "GetCinemasResponseVo{" +
                "status=" + status +
                ", nowPage=" + nowPage +
                ", totalPage=" + totalPage +
                ", map=" + map +
                '}';
    }
}
