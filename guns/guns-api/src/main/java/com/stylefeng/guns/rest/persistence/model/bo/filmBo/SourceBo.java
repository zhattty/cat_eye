package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/22 Time 22:00
 */
@Getter
@Setter
@ToString
public class SourceBo implements Serializable {
    private int sourceId;

    private String sourceName;

    private boolean isActive;
}
