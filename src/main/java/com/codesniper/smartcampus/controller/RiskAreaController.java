package com.codesniper.smartcampus.controller;

import com.alibaba.fastjson.JSON;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.RiskAreaReq;
import com.codesniper.smartcampus.entity.RiskArea;
import com.codesniper.smartcampus.service.RiskAreaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * (RiskArea)表控制层
 *
 * @author CodeSniper
 * @since 2022-01-29 01:44:10
 */
@RestController
@RequestMapping(value = "/riskArea")
@Api(tags = "风险地区")
public class RiskAreaController {
    
    private static final Logger logger = LoggerFactory.getLogger(RiskAreaController.class);

    @Autowired
    private RiskAreaService riskAreaService;

    @PostMapping(value = "/getRiskAreaList")
    @ApiOperation(value = "查询风险地区列表")
    public ResResult getRiskAreaList(RiskAreaReq dto){
        logger.info("查询风险地区列表参数:{}", JSON.toJSONString(dto));
        return ResResult.success(riskAreaService.getRiskAreaList(dto));
    }

    @PostMapping(value = "/getRiskAreaDetail")
    @ApiOperation(value = "查询风险地区详情")
    public ResResult getRiskAreaDetail(String id){
        logger.info("该风险地区id:{}",id);
        return ResResult.success(riskAreaService.getRiskAreaDetail(id));
    }

    @PostMapping(value = "/updateRiskArea")
    @ApiOperation(value = "编辑风险地区")
    public ResResult updateRiskArea(RiskArea dto){
        logger.info("编辑风险地区参数:{}",JSON.toJSONString(dto));
        riskAreaService.updateRiskArea(dto);
        return ResResult.success("编辑成功");
    }

}

