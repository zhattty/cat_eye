package com.stylefeng.guns.rest.modular.auth.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.stylefeng.guns.rest.common.persistence.model.User;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthRequest;
import com.stylefeng.guns.rest.modular.auth.controller.dto.AuthResponse;
import com.stylefeng.guns.rest.modular.auth.util.JwtTokenUtil;
import com.stylefeng.guns.rest.modular.vo.ResponseVo;
import com.stylefeng.guns.rest.persistence.api.UserAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 请求验证的
 *
 * @author fengshuonan
 * @Date 2017/8/24 14:22
 */
@RestController
public class AuthController {

    /*@Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Resource(name = "simpleValidator")
    private IReqValidator reqValidator;

    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseEntity<?> createAuthenticationToken(AuthRequest authRequest) {

        boolean validate = reqValidator.validate(authRequest);

        if (validate) {
            final String randomKey = jwtTokenUtil.getRandomKey();
            final String token = jwtTokenUtil.generateToken(authRequest.getUserName(), randomKey);
            // 把token传给了前端
            return ResponseEntity.ok(new AuthResponse(token, randomKey));
        } else {
            throw new GunsException(BizExceptionEnum.AUTH_REQUEST_ERROR);
        }
    }*/

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Reference(interfaceClass = UserAPI.class)
    private UserAPI userAPI;


    @RequestMapping(value = "${jwt.auth-path}")
    public ResponseVo createAuthenticationToken(AuthRequest authRequest) {
        String userName = authRequest.getUserName();
        String password = authRequest.getPassword();
        if (userName == null || "".equals(userName.trim())) {

            return ResponseVo.fail("用户名不能为空");
        }

        if (password == null || "".equals(password.trim())) {
            return ResponseVo.fail("密码不能为空");
        }

        Integer login = userAPI.login(userName, password);

        if(login==null) {
            return ResponseVo.systemExp("系统出现异常，请联系管理员");
        }
        else {
            if (login > 0) {
                final String randomKey = jwtTokenUtil.getRandomKey();
                // 这里的token是用户的uuid而不是原来的username
                final String token = jwtTokenUtil.generateToken(login.toString(), randomKey);
                // 把token传给了前端
                return ResponseVo.success(new AuthResponse(token, randomKey));
            } else {

                return ResponseVo.fail("用户名或密码错误");
            }
        }
    }

}
