package com.codesniper.smartcampus.controller;

import com.alibaba.fastjson.JSON;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.entity.UserInfo;
import com.codesniper.smartcampus.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户表(User)表控制层
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@RestController
@RequestMapping("user")
@Api(tags = "用户")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping(value = "/getPersonalInfo")
    @ApiOperation(value = "查询个人用户信息")
    public ResResult getPersonalInfo(String userId){
        logger.info("该用户的userId:{}",userId);
        return ResResult.success(userService.getPersonalInfo(userId));
    }

    @PostMapping(value = "/updatePersonalInfo")
    @ApiOperation(value = "编辑个人信息")
    public ResResult updatePersonalInfo(UserInfo dto){
        logger.info("编辑个人信息参数:{}", JSON.toJSONString(dto));
        return userService.updatePersonalInfo(dto);
    }

}

