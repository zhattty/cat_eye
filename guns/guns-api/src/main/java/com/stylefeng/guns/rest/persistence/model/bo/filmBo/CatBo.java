package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/22 Time 21:36
 */
@Getter
@Setter
@ToString
public class CatBo implements Serializable {
    private int catId;

    private String catName;

    private boolean isActive;
}
