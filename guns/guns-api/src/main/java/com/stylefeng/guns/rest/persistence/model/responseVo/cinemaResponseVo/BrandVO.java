package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by wawawa
 * Date 2019/4/23 Time 15:20
 */

public class BrandVO implements Serializable {

    private String brandId;
    private String brandName;
    private boolean isActive;

    @Override
    public String toString() {
        return "BrandVO{" +
                "brandId='" + brandId + '\'' +
                ", brandName='" + brandName + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
