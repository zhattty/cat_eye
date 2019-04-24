package com.stylefeng.guns.rest.persistence.model.bo.filmBo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ZhangYao
 * Date 2019/4/24 Time 14:33
 */
@Getter
@Setter
@ToString
public class ActorsBo implements Serializable {
    DirectorBo director;
    List<ActorBo> actors;
}
