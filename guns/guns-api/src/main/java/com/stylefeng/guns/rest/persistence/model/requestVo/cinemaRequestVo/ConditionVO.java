package com.stylefeng.guns.rest.persistence.model.requestVo.cinemaRequestVo;

import java.io.Serializable;

/**
 * Created by wawawa
 * Date 2019/4/22 Time 18:00
 */
public class ConditionVO implements Serializable {

    private int brandId;
    private int hallType;
    private int areaId;

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public int getHallType() {
        return hallType;
    }

    public void setHallType(int hallType) {
        this.hallType = hallType;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    @Override
    public String toString() {
        return "GetConditionRequestVo{" +
                "brandId=" + brandId +
                ", hallType=" + hallType +
                ", areaId=" + areaId +
                '}';
    }
}
