package com.stylefeng.guns.user.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.stylefeng.guns.core.util.MD5Util;
import com.stylefeng.guns.rest.persistence.api.UserAPI;
import com.stylefeng.guns.rest.persistence.model.bo.userBo.UserInfoModel;
import com.stylefeng.guns.rest.persistence.model.bo.userBo.UserModel;
import com.stylefeng.guns.user.persistence.dao.MtimeUserTMapper;
import com.stylefeng.guns.user.persistence.model.MtimeUserT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * ClassName: UserServiceImpl
 * Description:
 *
 * @author mighty
 * @version 1.0
 * @date 2019/4/22  21:51
 */
@Component
@Service(interfaceClass = UserAPI.class)
public class UserServiceImpl implements UserAPI {

    @Autowired
    private MtimeUserTMapper mtimeUserTMapper;


    @Override
    public Integer login(String userName, String password) {
        MtimeUserT mtimeUserT = new MtimeUserT();
        mtimeUserT.setUserName(userName);
        mtimeUserT.setUserPwd(MD5Util.encrypt(password));

        MtimeUserT result = mtimeUserTMapper.selectOne(mtimeUserT);
        if(result!=null) {
            return result.getUuid();
        }
        else {
            return -1;
        }
    }

    @Override
    public Boolean register(UserModel userModel) {
        MtimeUserT mtimeUserT = new MtimeUserT();
        mtimeUserT.setUserName(userModel.getUsername());
        mtimeUserT.setAddress(userModel.getAddress());
        mtimeUserT.setEmail(userModel.getEmail());
        mtimeUserT.setUserPhone(userModel.getPhone());

        // 密码MD5加密,没有加盐
        String encrypt = MD5Util.encrypt(userModel.getPassword());
        mtimeUserT.setUserPwd(encrypt);

        Integer insert = mtimeUserTMapper.insert(mtimeUserT);

        return insert>0;

    }

    @Override
    public boolean checkUsername(String userName) {
        EntityWrapper<MtimeUserT> entityWrapper = new EntityWrapper<>();
        entityWrapper.eq("user_name", userName);
        Integer result = mtimeUserTMapper.selectCount(entityWrapper);

        return result>0;
    }

    @Override
    public UserInfoModel getUserInfo(Integer uuid) {
        MtimeUserT mtimeUserT = mtimeUserTMapper.selectById(uuid);
        return  tUserToUserM(mtimeUserT);

    }

    @Override
    public UserInfoModel updateUserInfo(UserInfoModel userInfoModel) {
        MtimeUserT mtimeUserT = new MtimeUserT();
        mtimeUserT.setUuid(userInfoModel.getUuid());
        mtimeUserT.setUserSex(userInfoModel.getSex());
        mtimeUserT.setNickName(userInfoModel.getNickname());
        mtimeUserT.setLifeState(userInfoModel.getLifeState());
        mtimeUserT.setHeadUrl(userInfoModel.getHeadAddress());
        mtimeUserT.setBirthday(userInfoModel.getBirthday());
        mtimeUserT.setBiography(userInfoModel.getBiography());
        mtimeUserT.setUserName(userInfoModel.getUsername());
        //mtimeUserT.setUserPwd(null);
        mtimeUserT.setAddress(userInfoModel.getAddress());
        mtimeUserT.setEmail(userInfoModel.getEmail());
        mtimeUserT.setUserPhone(userInfoModel.getPhone());
        mtimeUserT.setBeginTime(null);
        mtimeUserT.setUpdateTime(null);
        Integer integer = mtimeUserTMapper.updateById(mtimeUserT);
        if(integer>0) {
            return tUserToUserM(mtimeUserT);
        }
        else {
            return null;
        }
    }

    /*po转为bo*/
    private UserInfoModel tUserToUserM(MtimeUserT mtimeUserT) {
        UserInfoModel model = new UserInfoModel();
        model.setUuid(mtimeUserT.getUuid());
        model.setSex(mtimeUserT.getUserSex());
        model.setUsername(mtimeUserT.getUserName());
        model.setUpdateTime(mtimeUserT.getUpdateTime());
        model.setPhone(mtimeUserT.getUserPhone());
        //model.setPassword(mtimeUserT.getUserPwd());
        model.setNickname(mtimeUserT.getNickName());
        model.setLifeState(mtimeUserT.getLifeState());
        model.setHeadAddress(mtimeUserT.getHeadUrl());
        model.setEmail(mtimeUserT.getEmail());
        model.setCreateTime(mtimeUserT.getBeginTime());
        model.setBirthday(mtimeUserT.getBirthday());
        model.setBiography(mtimeUserT.getBiography());
        model.setAddress(mtimeUserT.getAddress());
        return model;

    }
}
