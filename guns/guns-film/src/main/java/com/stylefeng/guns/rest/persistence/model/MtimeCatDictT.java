package com.stylefeng.guns.rest.persistence.model;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 类型信息表
 * </p>
 *
 * @author ZhangYao
 * @since 2019-04-21
 */
@TableName("mtime_cat_dict_t")
public class MtimeCatDictT extends Model<MtimeCatDictT> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键编号
     */
    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;
    /**
     * 显示名称
     */
    @TableField("show_name")
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
    protected Serializable pkVal() {
        return this.uuid;
    }

    @Override
    public String toString() {
        return "MtimeCatDictT{" +
        "uuid=" + uuid +
        ", showName=" + showName +
        "}";
    }
}
