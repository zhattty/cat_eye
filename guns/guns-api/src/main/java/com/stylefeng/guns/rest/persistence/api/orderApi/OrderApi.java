package com.stylefeng.guns.rest.persistence.api.orderApi;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.responseVo.orderResVo.OrderVo;

import java.io.IOException;

/**
 * Created by ZhangYao
 * Date 2019/4/24 Time 17:59
 */
public interface OrderApi {

    // 根据fieldId，获得说有已销售座位的编号
    String getSoldSeatsByFieldId(Integer filedId) throws Exception;

    // 使用当前登录人获得已购买影片的订单
    Page<OrderVo> getOrderByUserId(Page<OrderVo> page, Integer userId);

    // 创建订单信息
    OrderVo saveOrderInfo(Integer fieldId, String soldSeats, String seatsName, Integer userId) throws Exception;

    // 已销售的座位里有没有这些座位
    boolean isNotSoldSeats(String fieldId, String seats) throws Exception;

    // 验证售出的票是否为真
    boolean isTrueSeats(String fieldId, String seats) throws IOException;
}
