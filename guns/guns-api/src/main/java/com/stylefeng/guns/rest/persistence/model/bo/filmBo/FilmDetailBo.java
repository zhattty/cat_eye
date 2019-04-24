package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 20:45
 */
@Getter
@Setter
@ToString
public class FilmDetailBo implements Serializable {
    String filmName;
    String filmEnName;
    String imgAddress;
    double score;
    double scoreNum;
    int totalBox;
    int filmId;

    // 数据库查出来的之后来转化为info01
    String filmCats;
    // 转化为info02
    String filmArea;
    // 转化为info3;
    Date filmTime;
    int filmLength;
    int filmSource;

    // 用来生成外层封装那个map
    String filmImgs;

    // 用来生成info4的部分
    InfoBo info04;
    int directId;

    public InfoBo getInfo04() {
        return info04;
    }

    public void setInfo04(InfoBo info04) {
        this.info04 = info04;
    }
}
