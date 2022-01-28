package com.codesniper.smartcampus.controller;

import com.alibaba.fastjson.JSON;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.UserHealthReq;
import com.codesniper.smartcampus.entity.UserHealth;
import com.codesniper.smartcampus.service.UserHealthService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 用户健康状况(UserHealth)表控制层
 *
 * @author xwgong4
 * @since 2022-01-27 15:28:23
 */
@RestController
@Api(tags = "健康状况")
@RequestMapping("/userHealth")
public class UserHealthController {

    private static final Logger logger = LoggerFactory.getLogger(UserHealthController.class);

    @Autowired
    private UserHealthService userHealthService;

    @PostMapping(value = "/getUserHealthList")
    @ApiOperation(value = "查询健康状况列表")
    public ResResult getUserHealthList(UserHealthReq dto){
        logger.info("查询健康状况参数:{}", JSON.toJSONString(dto));
        return ResResult.success(userHealthService.getUserHealthList(dto));
    }

    @PostMapping(value = "/getUserHealthDetail")
    @ApiOperation(value = "查询健康状况")
    public ResResult getUserHealthDetail(String id){
        logger.info("该条数据id:{}",id);
        return ResResult.success(userHealthService.getUserHealthDetail(id));
    }

    @PostMapping(value = "/updateUserHealth")
    @ApiOperation(value = "编辑健康状况")
    public ResResult updateUserHealth(UserHealth dto){
        logger.info("编辑健康状况参数:{}",JSON.toJSONString(dto));
        userHealthService.updateUserHealth(dto);
        return ResResult.success("编辑成功");
    }

    @PostMapping(value = "/getHealthListByManager")
    @ApiOperation(value = "管理员查看学生健康状况")
    public ResResult getHealthListByManager(UserHealthReq dto){
        logger.info("管理员查询学生状况参数:{}",JSON.toJSONString(dto));
        return ResResult.success(userHealthService.getHealthListByManager(dto));
    }
}

