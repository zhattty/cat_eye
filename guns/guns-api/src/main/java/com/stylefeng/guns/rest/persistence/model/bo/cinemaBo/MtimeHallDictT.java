package com.stylefeng.guns.rest.persistence.model.bo.cinemaBo;

/**
 * <p>
 * 地域信息表
 * </p>
 *
 * @author jack
 * @since 2019-04-22
 */
public class MtimeHallDictT {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer uuid;
    /**
     * 显示名称
     */
    private String showName;
    /**
     * 座位文件存放地址
     */
    private String seatAddress;


    public Integer getUuid() {
        return uuid;
    }

    public void setUuid(Integer uuid) {
        this.uuid = uuid;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getSeatAddress() {
        return seatAddress;
    }

    public void setSeatAddress(String seatAddress) {
        this.seatAddress = seatAddress;
    }

    @Override
    public String toString() {
        return "MtimeHallDictT{" +
        "uuid=" + uuid +
        ", showName=" + showName +
        ", seatAddress=" + seatAddress +
        "}";
    }
}
