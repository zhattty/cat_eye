package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/22 Time 22:04
 */
@Getter
@Setter
@ToString
public class YearBo implements Serializable {

    private int yearId;

    private String yearName;

    private boolean isActive;

}
