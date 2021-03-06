package com.stylefeng.guns.rest.persistence.model.bo.filmBo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/21 Time 20:43
 */
@Getter
@Setter
@ToString
public class BannerBo implements Serializable {
    /**
     * 对应banner表里的uuid
     */
    int bannerId;

    String bannerAddress;

    String bannerUrl;

}
