package com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.InfoBo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 21:40
 */
@Setter
@Getter
@ToString
public class FilmDetailVo {
    String filmName;
    String filmEnName;
    String imgAddress;
    double score;
    double scoreNum;
    int totalBox;

    // 数据库查出来的之后来转化为info01
    String info01;
    // 转化为info02
    String info02;
    // 转化为info3;
    String info03;

    InfoBo info04;
}
