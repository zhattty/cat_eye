package com.stylefeng.guns.rest.persistence.model.responseVo.orderResVo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ZhangYao
 * Date 2019/4/26 Time 16:09
 */
@Data
@ToString
public class PayInfoVo implements Serializable {
    int status;
    String msg;
    String imgPre;
    Map<String,String> data;

    public static PayInfoVo ok(String imgPre, String orderId, String QRCodeAddress){
        PayInfoVo payInfoVo = new PayInfoVo();
        payInfoVo.setStatus(0);
        payInfoVo.setImgPre(imgPre);
        HashMap<String, String> map = new HashMap<>();
        map.put("orderId", orderId);
        map.put("QRCodeAddress", QRCodeAddress);
        payInfoVo.setData(map);
        return payInfoVo;
    }

    public static PayInfoVo fail(int status, String msg){
        PayInfoVo payInfoVo = new PayInfoVo();
        payInfoVo.setStatus(status);
        payInfoVo.setMsg(msg);
        return payInfoVo;
    }
}
