package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by ZhangYao
 * Date 2019/4/23 Time 21:11
 */
@Setter
@ToString
@Getter
public class InfoBo implements Serializable {
    String biography;
    ActorsBo actors;
}
