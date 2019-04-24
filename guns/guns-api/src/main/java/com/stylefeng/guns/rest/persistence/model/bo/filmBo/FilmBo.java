package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ZhangYao
 * Date 2019/4/22 Time 17:32
 */
@Setter
@Getter
@ToString
public class FilmBo implements Serializable {
    int filmId;
    int filmType;
    String imgAddress;
    String filmName;
    double filmScore;
    int expectNum;
    Date showTime;
    double score;
    int boxNum;
}
