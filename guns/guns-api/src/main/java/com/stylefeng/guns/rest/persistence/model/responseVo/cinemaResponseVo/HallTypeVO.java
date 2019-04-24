package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by wawawa
 * Date 2019/4/23 Time 15:15
 */

public class HallTypeVO implements Serializable {

    private String halltypeId;
    private String halltypeName;
    private boolean isActive;

    public String getHalltypeId() {
        return halltypeId;
    }

    public void setHalltypeId(String halltypeId) {
        this.halltypeId = halltypeId;
    }

    public String getHalltypeName() {
        return halltypeName;
    }

    public void setHalltypeName(String halltypeName) {
        this.halltypeName = halltypeName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "HallTypeVO{" +
                "halltypeId='" + halltypeId + '\'' +
                ", halltypeName='" + halltypeName + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
