package com.codesniper.smartcampus.controller;

import com.alibaba.fastjson.JSON;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.ApplyRecordReq;
import com.codesniper.smartcampus.entity.ApplyInfo;
import com.codesniper.smartcampus.service.ApplyInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户申请信息表(ApplyInfo)表控制层
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@RestController
@RequestMapping(value = "/applyInfo")
@Api(tags = "用户信息")
public class ApplyInfoController {
    
    private static final Logger logger = LoggerFactory.getLogger(ApplyInfoController.class);

    @Autowired
    private ApplyInfoService applyInfoService;

    @PostMapping(value = "/getApplyRecordList")
    @ApiOperation(value = "查询申请记录列表")
    public ResResult getApplyRecordList(ApplyRecordReq dto){
        logger.info("查询申请列表参数:{}", JSON.toJSONString(dto));
        return ResResult.success(applyInfoService.getApplyRecordList(dto));
    }

    @PostMapping(value = "/getApplyRecordDetail")
    @ApiOperation(value = "查询详情")
    public ResResult getApplyRecordDetail(String id){
        logger.info("该条数据id:{}",id);
        return ResResult.success(applyInfoService.getApplyRecordDetail(id));
    }

    @PostMapping(value = "/doApplication")
    @ApiOperation(value = "用户申请")
    public ResResult doApplication(ApplyInfo dto){
        logger.info("申请信息参数:{}",JSON.toJSONString(dto));
        applyInfoService.insertToApplication(dto);
        return ResResult.success("申请成功");
    }
}

