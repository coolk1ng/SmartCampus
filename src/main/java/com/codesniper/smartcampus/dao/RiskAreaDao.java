package com.codesniper.smartcampus.dao;


import com.codesniper.smartcampus.dto.RiskAreaReq;
import com.codesniper.smartcampus.entity.RiskArea;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (RiskArea)表数据库访问层
 *
 * @author CodeSniper
 * @since 2022-01-29 01:44:10
 */
@Mapper
public interface RiskAreaDao {

    /**
     * 查询风险地区列表
     * @param dto
     * @return List<RiskArea>
     */
    List<RiskArea> getRiskAreaList(RiskAreaReq dto);

    /**
     * 根据id查询
     * @param id
     * @return RiskArea
     */
    RiskArea queryById(String id);

    /**
     * 编辑风险地区
     * @param dto
     * @return void
     */
    void updateRiskArea(RiskArea dto);

}

