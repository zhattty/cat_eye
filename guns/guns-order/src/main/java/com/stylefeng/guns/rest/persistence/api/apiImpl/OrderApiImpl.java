package com.stylefeng.guns.rest.persistence.api.apiImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.api.orderApi.OrderApi;
import com.stylefeng.guns.rest.persistence.dao.MtimeFieldTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeHallDictTMapper;
import com.stylefeng.guns.rest.persistence.dao.MtimeOrderTMapper;
import com.stylefeng.guns.rest.persistence.model.MtimeFieldT;
import com.stylefeng.guns.rest.persistence.model.MtimeOrderT;
import com.stylefeng.guns.rest.persistence.model.responseVo.orderResVo.OrderVo;
import com.stylefeng.guns.rest.persistence.utils.StringArrayConcatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.*;

/**
 * Created by ZhangYao
 * Date 2019/4/25 Time 15:12
 */
@Component
@Service(interfaceClass = OrderApi.class)
public class OrderApiImpl implements OrderApi{
    @Autowired
    MtimeOrderTMapper mtimeOrderTMapper;

    @Autowired
    MtimeFieldTMapper mtimeFieldTMapper;

    @Autowired
    MtimeHallDictTMapper mtimeHallDictTMapper;

    @Override
    public String getSoldSeatsByFieldId(Integer filedId) throws Exception {
        // 查出来的结果拼成一个字符串
        return StringArrayConcatUtil.concatWithSperator(mtimeOrderTMapper.getSoldSeatsByFieldId(filedId),",");
    }

    @Override
    public Page<OrderVo> getOrderByUserId(Page<OrderVo> page, Integer userId) {
        return page.setRecords(mtimeOrderTMapper.getOrderByUserId(page, userId));
    }

    @Override
    public OrderVo saveOrderInfo(Integer fieldId, String soldSeats, String seatsName, Integer userId) throws Exception {
        // 插入
        String[] split = soldSeats.split(",");
        MtimeFieldT field = mtimeFieldTMapper.selectById(fieldId);
        MtimeOrderT order = new MtimeOrderT();
        order.setUuid(UUID.randomUUID().toString().replace("-",""));
        order.setCinemaId(field.getCinemaId());
        order.setFieldId(fieldId);
        order.setFilmId(field.getFilmId());
        order.setSeatsIds(soldSeats);
        order.setSeatsName(seatsName);
        order.setFilmPrice(field.getPrice().doubleValue());
        order.setOrderPrice((double) field.getPrice()*split.length);
        order.setOrderUser(userId);
        order.setOrderStatus(0);
        Integer insert = mtimeOrderTMapper.insert(order);
        if (insert != 1){
            throw new Exception("插入订单失败");
        }
        // 查询orderVo
        return mtimeOrderTMapper.selectOrderVoByUserId(userId);
    }

    @Override
    public boolean isNotSoldSeats(String fieldId, String seats) throws Exception {
        String soldSeatsByFieldId = getSoldSeatsByFieldId(Integer.parseInt(fieldId));
        String[] soldSeats = soldSeatsByFieldId.split(",");
        HashSet<String> set = new HashSet<>();
        for (String soldSeat : soldSeats) {
            set.add(soldSeat);
        }
        String[] seatsToBuy = seats.split(",");
        for (String s : seatsToBuy) {
            if (set.contains(s)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isTrueSeats(String fieldId, String seats) throws IOException {
        // 先拿到json文件
        String address = mtimeHallDictTMapper.selectHallSeatAddressByFieldId(fieldId);
        File file = new File("d:/" + address);
        FileReader fileReader = new FileReader(file);
        if (fileReader != null){
            BufferedReader reader = new BufferedReader(fileReader);
            String slice = null;

            StringBuilder sb = new StringBuilder();
            while (( slice= reader.readLine()) != null){
                sb.append(slice);
            }
            System.out.println(sb.toString());
            Map allseats = (Map) JSON.parse(sb.toString().trim());
            String ids = (String) allseats.get("ids");
            String[] split = ids.split(",");
            Set<String> set = new HashSet<>();
            if(split != null){
                for (String s : split) {
                    set.add(s);
                }
            }
            String[] seatsToBuy = seats.split(",");
            for (String seat : seatsToBuy) {
                if (!set.contains(seat)){
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
