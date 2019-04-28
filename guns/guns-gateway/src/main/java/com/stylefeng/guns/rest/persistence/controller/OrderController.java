package com.stylefeng.guns.rest.persistence.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alipay.demo.trade.Main;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.CurrentUser;
import com.stylefeng.guns.rest.persistence.api.orderApi.OrderApi;
import com.stylefeng.guns.rest.persistence.model.responseVo.orderResVo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ZhangYao
 * Date 2019/4/25 Time 18:36
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @Reference(interfaceClass = OrderApi.class)
    OrderApi orderApi;
    @RequestMapping(value = "/buyTickets", method = RequestMethod.POST)
    public BuyTicketsResVo buyTickets(@RequestParam("fieldId") String fieldId,
                                      @RequestParam("soldSeats") String soldSeats,
                                      @RequestParam("seatsName") String seatsName){
        BuyTicketsResVo buyTicketsResVo = new BuyTicketsResVo();
        try {
            boolean areSeatsExsit = orderApi.isTrueSeats(fieldId, soldSeats);
            boolean areSeatsNotSold = orderApi.isNotSoldSeats(fieldId, soldSeats);
            if (!areSeatsExsit){
                buyTicketsResVo.setStatus(1);
                buyTicketsResVo.setMsg("不存在的座位");
                return buyTicketsResVo;
            }
            if (!areSeatsNotSold){
                buyTicketsResVo.setStatus(1);
                buyTicketsResVo.setMsg("座位已售出");
                return buyTicketsResVo;
            }

            String currentUser = CurrentUser.getCurrentUser();
            OrderVo orderVo = orderApi.saveOrderInfo(Integer.parseInt(fieldId), soldSeats, seatsName, Integer.parseInt(currentUser));
            buyTicketsResVo.setOrderVo(orderVo);
        }catch (Exception e){
            e.printStackTrace();
            buyTicketsResVo.setStatus(999);
            buyTicketsResVo.setMsg("系统错误，请联系管理员");
            return buyTicketsResVo;
        }
        buyTicketsResVo.setStatus(0);
        return buyTicketsResVo;
    }

    @RequestMapping(value = "/getOrderInfo", method = RequestMethod.POST)
    public OrderInfoVo getOrderInfo(@RequestParam(name = "nowPage", defaultValue = "1") Integer nowPage,
                                    @RequestParam(name = "pageSize", defaultValue = "5") Integer pageSize){
        OrderInfoVo orderInfoVo = new OrderInfoVo();

        try {
            Page<OrderVo> page = new Page<>();
            page.setSize(pageSize);
            page.setCurrent(nowPage);
            String currentUser = CurrentUser.getCurrentUser();
            Page<OrderVo> orderByUserId = orderApi.getOrderByUserId(page, Integer.parseInt(currentUser));
            if (orderByUserId.getRecords().size() == 0){
                orderInfoVo.setStatus(1);
                orderInfoVo.setMsg("订单列表为空哦");
                return orderInfoVo;
            }
            orderInfoVo.setData(orderByUserId.getRecords());
        } catch (Exception e){
            e.printStackTrace();
            orderInfoVo.setStatus(999);
            orderInfoVo.setMsg("系统错误请联系管理员");
            return orderInfoVo;
        }
        orderInfoVo.setStatus(0);
        return orderInfoVo;
    }


    @RequestMapping(value = "/getPayInfo", method = RequestMethod.POST)
    public PayInfoVo getPayInfo(@RequestParam("orderId") String orderId){
        PayInfoVo vo = null;
        try {
            double totalPriceByOrderId = orderApi.getTotalPriceByOrderId(orderId);
            Main main = new Main();
            String qrPath = main.test_trade_precreate(orderId, totalPriceByOrderId);
            if ("".equals(qrPath)) {
                return PayInfoVo.fail(1,"创建payInfo失败");
            }

            vo = PayInfoVo.ok("http://localhost/aliPayQRCode/", orderId, qrPath);
        }catch (Exception e){
            e.printStackTrace();
            return PayInfoVo.fail(999,"系统错误请联系管理员");
        }
        return vo;
    }

    @RequestMapping(value = "/getPayResult", method = RequestMethod.POST)
    public PayResultVo getPayResult(@RequestParam("orderId")String orderId,
                                    @RequestParam(name = "tryNums", defaultValue = "1") Integer tryNums){
        if (tryNums>3){
            return PayResultVo.fail(1,"订单支付失败，请稍后重试");
        }
        PayResultVo vo = null;
        try {
            Main main = new Main();
            Boolean isTradeSuccess = main.test_trade_query(orderId);
            if (isTradeSuccess){
                vo = PayResultVo.ok(orderId,1,"支付成功");
                Integer result = orderApi.updateOrderStatusByOrderId( orderId, 1);
            }else {
                vo = PayResultVo.ok(orderId,3,"支付未成功");
            }
        }catch (Exception e){
            e.printStackTrace();
            return PayResultVo.fail(999, "系统出错请联系管理员");
        }
        return vo;
    }
}
