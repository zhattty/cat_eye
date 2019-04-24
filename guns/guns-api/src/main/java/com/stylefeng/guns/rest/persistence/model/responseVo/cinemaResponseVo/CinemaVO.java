package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;

import java.io.Serializable;

/**
 * <p>
 * 影院信息表
 * </p>
 *
 * @author jack
 * @since 2019-04-22
 */
public class CinemaVO implements Serializable {



    /**
     * 主键编号
     */
    private Integer id;
    /**
     * 影院名称
     */
    private String cinemaName;

    /**
     * 影院地址
     */
    private String address;
    /**
     * 最低票价
     */
    private Integer minimumPrice;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getMinimumPrice() {
        return minimumPrice;
    }

    public void setMinimumPrice(Integer minimumPrice) {
        this.minimumPrice = minimumPrice;
    }

    @Override
    public String toString() {
        return "MtimeCinemaT{" +
        "uuid=" + id +
        ", cinemaName=" + cinemaName +
        ", cinemaAddress=" + address +
        ", minimumPrice=" + minimumPrice +
        "}";
    }
}
