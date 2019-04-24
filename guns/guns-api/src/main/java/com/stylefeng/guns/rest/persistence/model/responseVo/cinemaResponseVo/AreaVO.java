package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by wawawa
 * Date 2019/4/23 Time 15:15
 */
@Setter
@Getter
@ToString
public class AreaVO implements Serializable {
    private String brandId;
    private String brandName;
    private boolean isActive;

}
