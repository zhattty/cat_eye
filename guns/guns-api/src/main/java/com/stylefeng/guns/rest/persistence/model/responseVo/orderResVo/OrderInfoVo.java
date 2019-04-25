package com.stylefeng.guns.rest.persistence.model.responseVo.orderResVo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/25 Time 19:00
 */
@Setter
@Getter
@ToString
public class OrderInfoVo implements Serializable {
    private int status;
    private String msg;
    private List<OrderVo> data;
}
