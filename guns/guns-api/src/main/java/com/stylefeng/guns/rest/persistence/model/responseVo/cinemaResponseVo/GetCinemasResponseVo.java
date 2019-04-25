package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by wawawa
 * Date 2019/4/22 Time 17:46
 */
@Setter
@Getter
@ToString
public class GetCinemasResponseVo implements Serializable {

    private int status;
    private int nowPage;
    private int totalPage;
    private Map<String,Object> data;


}
