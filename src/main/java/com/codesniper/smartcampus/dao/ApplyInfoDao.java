package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.dto.ApplyRecordReq;
import com.codesniper.smartcampus.entity.ApplyInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户申请信息表(ApplyInfo)表数据库访问层
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@Mapper
public interface ApplyInfoDao {

    /** 
     * 查询申请记录列表
     * @param dto
     * @return List<ApplyInfo>
     */ 
    List<ApplyInfo> getApplyRecordList(ApplyRecordReq dto);

    /**
     * 查询详情
     * @param id
     * @return ApplyInfo
     */
    ApplyInfo getApplyRecordDetail(String id);

    /**
     * 用户申请
     * @param dto
     * @return void
     */
    void InsertToApplication(ApplyInfo dto);

}

