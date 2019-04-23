package com.stylefeng.guns.rest.persistence.model.bo.userBo;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * ClassName: UserModel
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/23  11:16
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserModel implements Serializable {
    private Integer uuid;
    private String username;
    private String password;
    private String email;
    private String phone;
    private String address;
}
