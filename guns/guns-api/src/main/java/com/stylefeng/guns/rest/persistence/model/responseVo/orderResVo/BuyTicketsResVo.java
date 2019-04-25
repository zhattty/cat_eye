package com.stylefeng.guns.rest.persistence.model.responseVo.orderResVo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/25 Time 18:40
 */
@Data
@ToString
public class BuyTicketsResVo implements Serializable {
    private int status;
    private String msg;
    private OrderVo orderVo;
}
