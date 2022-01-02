package com.codesniper.smartcampus.controller;


import com.alibaba.fastjson.JSONObject;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.LoginParams;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 用户登录
 *
 * @author CodeSniper
 * @since 2022-01-03
 */
@RestController
@Api(tags = "用户登录")
@RequestMapping(value = "/")
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录后返回token")
    @PostMapping(value = "/login")
    public ResResult login(LoginParams loginParams, HttpServletRequest httpServletRequest){
        logger.info("用户登录传入参数:{}", JSONObject.toJSONString(loginParams));
        return userService.login(loginParams.getUsername(),loginParams.getPassword(),httpServletRequest);
    }

    @ApiOperation(value = "根据用户名获取当前用户信息")
    @PostMapping(value = "/getUserInfo")
    public ResResult getUserInfo(Principal principal){
        if (null==principal){
            return ResResult.fail("不存在该用户");
        }
        String username = principal.getName();
        User user = userService.getUserInfoByUsername(username);
        user.setPassword(null);
        return ResResult.success(user);
    }

    @ApiOperation(value = "退出登录")
    @PostMapping(value = "/logout")
    public ResResult logout(){
        return ResResult.success("注销成功");
    }

}
