package com.codesniper.smartcampus.controller;

import com.alibaba.fastjson.JSON;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.StudentManageReq;
import com.codesniper.smartcampus.entity.UserInfo;
import com.codesniper.smartcampus.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
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
    @ApiOperation(value = "查询学生列表")
    public ResResult getStudentList(StudentManageReq dto){
        logger.info("查询学生列表参数:{}", JSON.toJSONString(dto));
        return ResResult.success(userInfoService.getStudentList(dto));
    }

    @PostMapping(value = "/deleteStudent")
    @ApiOperation(value = "批量删除")
    public ResResult deleteStudent(String userIds){
        logger.info("删除学生Id:{}",JSON.toJSONString(userIds));
        userInfoService.deleteStudentInfo(userIds);
        return ResResult.success("删除成功");
    }

    @PostMapping(value = "/addAndEditStudent")
    @ApiOperation(value = "新增,编辑")
    public ResResult addAndEditStudent(UserInfo dto){
        logger.info("新增,编辑参数:{}",JSON.toJSONString(dto));
        String result = "";
        if (StringUtils.isNotBlank(dto.getUserId())){
            result = "编辑成功";
        }else{
            result = "新增成功";
        }
        userInfoService.addAndEditStudent(dto);
        return ResResult.success(result);
    }

    @PostMapping(value = "/getDetail")
    @ApiOperation(value = "查询详情")
    public ResResult getDetail(String userId){
        logger.info("该学生id:{}",userId);
        return ResResult.success(userInfoService.getDetail(userId));
    }
}

