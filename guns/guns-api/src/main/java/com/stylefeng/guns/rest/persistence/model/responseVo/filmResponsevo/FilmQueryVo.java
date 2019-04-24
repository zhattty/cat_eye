package com.stylefeng.guns.rest.persistence.model.responseVo.filmResponsevo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by ZhangYao
 * Date 2019/4/21 Time 15:59
 */
@Getter
@Setter
@ToString
public class FilmQueryVo implements Serializable {
    /**
     *  0 表示正常
     *  1 查询失败
     *  999 系统异常请联系管理员
     */
   private int status;

   private String imgPre;

   private String msg;

   private Map<String, Object>  data;

}
