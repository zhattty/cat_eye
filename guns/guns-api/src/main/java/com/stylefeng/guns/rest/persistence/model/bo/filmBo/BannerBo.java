package com.stylefeng.guns.rest.persistence.model.bo.filmBo;


import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/21 Time 20:43
 */
public class BannerBo implements Serializable {
    /**
     * 对应banner表里的uuid
     */
    int bannerId;

    String bannerAddress;

    String bannerUrl;

    public int getBannerId() {
        return bannerId;
    }

    public void setBannerId(int bannerId) {
        this.bannerId = bannerId;
    }

    public String getBannerAddress() {
        return bannerAddress;
    }

    public void setBannerAddress(String bannerAddress) {
        this.bannerAddress = bannerAddress;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    @Override
    public String toString() {
        return "Banner{" +
                "bannerId=" + bannerId +
                ", bannerAddress='" + bannerAddress + '\'' +
                ", bannerUrl='" + bannerUrl + '\'' +
                '}';
    }
}
