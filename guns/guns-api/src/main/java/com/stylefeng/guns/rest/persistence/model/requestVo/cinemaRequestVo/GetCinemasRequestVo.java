package com.stylefeng.guns.rest.persistence.model.requestVo.cinemaRequestVo;

import java.io.Serializable;

/**
 * Created by wawawa
 * Date 2019/4/22 Time 17:43
 */
public class GetCinemasRequestVo implements Serializable {
    private int brandId;
    private String  hallType;
    private int  districtId;


    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }


    public String getHallType() {
        return hallType;
    }

    public void setHallType(String hallType) {
        this.hallType = hallType;
    }

    public int getDistrictId() {
        return districtId;
    }

    public void setDistrictId(int districtId) {
        this.districtId = districtId;
    }

    @Override
    public String toString() {
        return "GetCinemasRequestVo{" +
                "brandId=" + brandId +
                ", hallType=" + hallType +
                ", districtId=" + districtId +
                '}';
    }
}
