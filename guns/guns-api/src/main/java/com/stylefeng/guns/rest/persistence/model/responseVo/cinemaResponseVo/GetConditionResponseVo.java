package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by wawawa
 * Date 2019/4/22 Time 18:01
 */
public class GetConditionResponseVo implements Serializable {

    private int status;

    private String imgPre;

    private Map<String, Object> map;

    public String getImgPre() {
        return imgPre;
    }

    public void setImgPre(String imgPre) {
        this.imgPre = imgPre;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "GetConditionResponseVo{" +
                "status=" + status +
                ", imgPre='" + imgPre + '\'' +
                ", map=" + map +
                '}';
    }
}
