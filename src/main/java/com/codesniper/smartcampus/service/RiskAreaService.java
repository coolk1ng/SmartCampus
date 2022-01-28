package com.codesniper.smartcampus.service;


import com.codesniper.smartcampus.dto.RiskAreaReq;
import com.codesniper.smartcampus.entity.RiskArea;
import com.github.pagehelper.PageInfo;

/**
 * (RiskArea)表服务接口
 *
 * @author CodeSniper
 * @since 2022-01-29 01:44:10
 */
public interface RiskAreaService {

    /**
     * 查询风险地区列表
     * @param dto
     * @return PageInfo<RiskArea>
     */
    PageInfo<RiskArea> getRiskAreaList(RiskAreaReq dto);

    /**
     * 查询详情
     * @param id
     * @return RiskArea
     */
    RiskArea getRiskAreaDetail(String id);

    /**
     * 编辑风险地区
     * @param dto
     * @return void
     */
    void updateRiskArea(RiskArea dto);

}
