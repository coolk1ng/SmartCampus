package com.codesniper.smartcampus.controller;


import com.alibaba.fastjson.JSON;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.PendingReq;
import com.codesniper.smartcampus.service.PendingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 待审批Controller
 *
 * @author CodeSniper
 * @since 2022-01-22
 */
@RequestMapping(value = "/pending")
@Api(tags = "待审批")
@RestController
public class PendingController {

    private static final Logger logger = LoggerFactory.getLogger(PendingController.class);

    @Autowired
    private PendingService pendingService;

    @PostMapping(value = "/getPendingList")
    @ApiOperation(value = "查询待审批列表")
    public ResResult getPendingList(PendingReq dto){
        logger.info("查询待审批列表参数:{}", JSON.toJSONString(dto));
        return ResResult.success(pendingService.getPendingList(dto));
    }

    @PostMapping(value = "/approveApplication")
    @ApiOperation(value = "批准,驳回申请")
    public ResResult approveApplication(PendingReq dto){
        logger.info("批准,驳回参数:{}",JSON.toJSONString(dto));
        pendingService.approveApplication(dto);
        return ResResult.success("审批成功");
    }

    @PostMapping(value = "/getPendingDetail")
    @ApiOperation(value = "查询详情")
    public ResResult getPendingDetail(String id){
        return ResResult.success(pendingService.getPendingDetail(id));
    }
}
