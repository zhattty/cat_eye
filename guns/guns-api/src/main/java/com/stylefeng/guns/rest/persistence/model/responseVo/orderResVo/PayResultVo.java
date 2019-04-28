package com.stylefeng.guns.rest.persistence.model.responseVo.orderResVo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangYao
 * Date 2019/4/26 Time 16:37
 */
@Data
@ToString
public class PayResultVo implements Serializable {
    private int status;
    private String msg;
    private Map<String, Object> data;

    public static PayResultVo ok(String orderId, Integer orderStatus, String orderMsg){
        PayResultVo payResultVo = new PayResultVo();
        payResultVo.setStatus(0);
        HashMap<String, Object> map = new HashMap<>();
        map.put("orderId",orderId);
        map.put("orderStatus", orderStatus);
        map.put("orderMsg", orderMsg);
        payResultVo.setData(map);
        return payResultVo;
    }

    public static PayResultVo fail(int status, String msg){
        PayResultVo payResultVo = new PayResultVo();
        payResultVo.setStatus(status);
        payResultVo.setMsg(msg);
        return payResultVo;
    }
}
