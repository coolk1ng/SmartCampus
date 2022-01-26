package com.codesniper.smartcampus.controller;

import com.alibaba.fastjson.JSON;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.ApprovalRecordReq;
import com.codesniper.smartcampus.entity.ApprovalRecord;
import com.codesniper.smartcampus.service.ApprovalRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 审批记录表(ApprovalRecord)表控制层
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@RestController
@Api(tags = "审批记录")
@RequestMapping(value = "/approvalRecord")
public class ApprovalRecordController {
    
    private static final Logger logger = LoggerFactory.getLogger(ApprovalRecordController.class);

    @Autowired
    private ApprovalRecordService approvalRecordService;

    @PostMapping(value = "/getApprovalRecordList")
    @ApiOperation(value = "查询审批记录列表")
    public ResResult getApprovalRecordList(ApprovalRecordReq dto){
        logger.info("查询记录列表参数:{}", JSON.toJSONString(dto));
        return ResResult.success(approvalRecordService.getApprovalRecordList(dto));
    }

    @PostMapping(value = "/getApprovalRecordDetail")
    @ApiOperation(value = "查询审批记录详情")
    public ResResult getApprovalRecordDetail(String id){
        logger.info("此条记录的用户Id:{}",id);
        return ResResult.success(approvalRecordService.getDetail(id));
    }

    @PostMapping(value = "/editApprovalRecord")
    @ApiOperation(value = "编辑审批记录")
    public ResResult editApprovalRecord(ApprovalRecord dto){
        logger.info("编辑参数:{}",JSON.toJSONString(dto));
        return approvalRecordService.editApprovalRecord(dto);
    }
}

