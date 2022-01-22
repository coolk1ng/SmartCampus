package com.codesniper.smartcampus.controller;

import com.alibaba.fastjson.JSON;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.StudentManageReq;
import com.codesniper.smartcampus.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户信息表(UserInfo)表控制层
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@RestController
@RequestMapping(value = "/userInfo")
@Api(tags = "学生管理")
public class UserInfoController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(value = "/getStudentList")
    @ApiOperation(value = "/查询学生列表")
    public ResResult getStudentList(StudentManageReq dto){
        logger.info("查询学生列表参数:{}", JSON.toJSONString(dto));
        return ResResult.success(userInfoService.getStudentList(dto));
    }

}

