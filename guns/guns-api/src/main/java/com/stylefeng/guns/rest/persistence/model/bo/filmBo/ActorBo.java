package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by ZhangYao
 * Date 2019/4/24 Time 11:26
 */
@Data
@Setter
@Getter
@ToString
public class ActorBo implements Serializable {
    String imgAddress;
    String directorName;
    String roleName;
}
