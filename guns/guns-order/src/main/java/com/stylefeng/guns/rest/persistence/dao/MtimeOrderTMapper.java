package com.stylefeng.guns.rest.persistence.dao;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.rest.persistence.model.MtimeOrderT;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.stylefeng.guns.rest.persistence.model.responseVo.orderResVo.OrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 订单信息表 Mapper 接口
 * </p>
 *
 * @author Zhangyao
 * @since 2019-04-25
 */
public interface MtimeOrderTMapper extends BaseMapper<MtimeOrderT> {

    String[] getSoldSeatsByFieldId(Integer filedId);

    List<OrderVo> getOrderByUserId(Page<OrderVo> page, @Param("id") Integer userId);

    OrderVo selectOrderVoByUserId(Integer userId);

    double getTotalPriceByOrderId(@Param("orderId") String orderId);

    Integer updateOrderStatusByOrderid(@Param("orderId") String orderId,@Param("status") int status);
}
