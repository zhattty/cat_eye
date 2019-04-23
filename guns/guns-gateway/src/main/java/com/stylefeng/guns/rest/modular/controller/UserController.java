package com.stylefeng.guns.rest.modular.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.CurrentUser;
import com.stylefeng.guns.rest.modular.vo.ResponseVo;
import com.stylefeng.guns.rest.persistence.api.UserAPI;
import com.stylefeng.guns.rest.persistence.model.bo.userBo.UserInfoModel;
import com.stylefeng.guns.rest.persistence.model.bo.userBo.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: UserController
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/23  16:03
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseVo register(UserModel userModel) {
        String userName = userModel.getUsername();
        String password = userModel.getPassword();

        if(userName==null || "".equals(userName.trim())) {
            return ResponseVo.fail("用户名不能为空");
        }
        if(password==null || "".equals(password.trim())) {
            return ResponseVo.fail("密码不能为空");
        }

        boolean b = userAPI.checkUsername(userName);
        if (b) {
            return ResponseVo.fail("用户已存在");
        }
        else {
            Boolean register = userAPI.register(userModel);
            if (register) {
                return ResponseVo.success("注册成功");
            }
            else {
                return ResponseVo.fail("系统出现异常，请联系管理员");
            }
        }
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST)
    public ResponseVo checkUsername(String username) {

        if(username == null || "".equals(username.trim())) {
            return ResponseVo.fail("用户已存在");
        }
        // 存在
        boolean b = userAPI.checkUsername(username);
        if (b) {
            return ResponseVo.fail("用户已存在");
        }
        else {
            return ResponseVo.success("验证成功");
        }
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    public ResponseVo getUserInfo() {
        // 从threadLocal中获取当前用户的id
        String userId = CurrentUser.getCurrentUser();
        Integer uuid = null;
        try {
            uuid = Integer.parseInt(userId);
        }catch (Exception e) {
            return ResponseVo.fail("查询失败，用户尚未登陆");
        }
        UserInfoModel userInfo = userAPI.getUserInfo(uuid);
        if (userInfo == null) {
            return ResponseVo.systemExp("系统出现异常，请联系管理员");
        }
        return ResponseVo.success(userInfo);
    }

    @RequestMapping(value = "/updateUserInfo", method = RequestMethod.POST)
    public ResponseVo updateUserInfo(UserInfoModel userInfoModel) {

        // 从threadLocal中获取当前用户的id
        String userId = CurrentUser.getCurrentUser();
        Integer uuid = null;
        try {
            uuid = Integer.parseInt(userId);
        }catch (Exception e) {
            return ResponseVo.fail("用户信息修改失败");
        }
        // 如果要修改别人的信息
        if(!uuid.equals(userInfoModel.getUuid())) {
            return ResponseVo.fail("用户信息修改失败");
        }
        UserInfoModel userInfo = userAPI.updateUserInfo(userInfoModel);
        if (userInfo == null) {
            return ResponseVo.systemExp("用户信息修改失败");
        }
        return ResponseVo.success(userInfo);
    }


}
