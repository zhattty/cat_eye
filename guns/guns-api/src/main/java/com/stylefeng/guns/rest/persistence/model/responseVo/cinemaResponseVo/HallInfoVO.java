package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaResponseVo;

import java.io.Serializable;

/**
 * Created by wawawa
 * Date 2019/4/23 Time 21:31
 */
public class HallInfoVO implements Serializable {

    private int hallFieldId;
    private String hallName;
    private String price;
    private String seatFile;
    // 已售座位必须关联订单才能查询
    private String soldSeats;

    @Override
    public String toString() {
        return "HallInfoVO{" +
                "hallFieldId=" + hallFieldId +
                ", hallName='" + hallName + '\'' +
                ", price='" + price + '\'' +
                ", seatFile='" + seatFile + '\'' +
                ", soldSeats='" + soldSeats + '\'' +
                '}';
    }

    public int getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(int hallFieldId) {
        this.hallFieldId = hallFieldId;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSeatFile() {
        return seatFile;
    }

    public void setSeatFile(String seatFile) {
        this.seatFile = seatFile;
    }

    public String getSoldSeats() {
        return soldSeats;
    }

    public void setSoldSeats(String soldSeats) {
        this.soldSeats = soldSeats;
    }
}
