package com.stylefeng.guns.rest.persistence.model.responseVo.cinemaVo;

import java.io.Serializable;

public class HallInfoVO implements Serializable {
 private String hallFieldId;
 private String hallName;
 private String price;
 private String seatFile;
 //已售座位须关联订单才能查询
 private String soldSeats;

    public String getHallFieldId() {
        return hallFieldId;
    }

    public void setHallFieldId(String hallFieldId) {
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
