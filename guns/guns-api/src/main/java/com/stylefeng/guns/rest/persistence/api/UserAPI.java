package com.stylefeng.guns.rest.persistence.api;

import com.stylefeng.guns.rest.persistence.model.bo.userBo.UserInfoModel;
import com.stylefeng.guns.rest.persistence.model.bo.userBo.UserModel;

/*
 * ClassName: UserAPI
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/23  11:59
 */

public interface UserAPI {

    Integer login(String userName, String password);

    Boolean register(UserModel userModel);

    boolean checkUsername(String userName);

    UserInfoModel getUserInfo(Integer uuid);

    UserInfoModel updateUserInfo(UserInfoModel userInfoModel);

}
