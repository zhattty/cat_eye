package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 21:14
 */
@Getter
@Setter
@ToString
public class DirectorBo implements Serializable {
    String imgAddress;
    String directorName;
}
