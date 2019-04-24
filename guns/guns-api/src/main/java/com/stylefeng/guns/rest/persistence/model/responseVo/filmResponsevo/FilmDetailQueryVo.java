package com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo;

import com.stylefeng.guns.rest.persistence.model.bo.filmBo.FilmDetailBo;
import com.stylefeng.guns.rest.persistence.model.bo.filmBo.InfoBo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 20:42
 */
@Setter
@Getter
@ToString
public class FilmDetailQueryVo {
    private int status;
    private String msg;
    private int filmId;
    private String imgPre;
    private FilmDetailVo data;
    Map<String, String> imgs;
}
