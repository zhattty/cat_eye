package com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmBo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 15:09
 */
@Setter
@Getter
@ToString
public class FilmSearchQueryVo implements Serializable {
    private int status;

    private String imgPre;

    private String msg;

    private List<FilmBo> data;

    private int nowPage;

    private int totalPage;
}
