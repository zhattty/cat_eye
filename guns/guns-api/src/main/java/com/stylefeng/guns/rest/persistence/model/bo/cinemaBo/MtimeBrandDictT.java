package com.stylefeng.guns.rest.persistence.model.bo.cinemaBo;

/**
 * <p>
 * 品牌信息表
 * </p>
 *
 * @author jack
 * @since 2019-04-22
 */
public class MtimeBrandDictT  {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    private Integer uuid;
    /**
     * 显示名称
     */
    private String showName;


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


    @Override
    public String toString() {
        return "MtimeBrandDictT{" +
        "uuid=" + uuid +
        ", showName=" + showName +
        "}";
    }
}
