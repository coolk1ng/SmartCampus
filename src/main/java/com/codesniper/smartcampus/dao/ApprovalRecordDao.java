package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.dto.ApprovalRecordReq;
import com.codesniper.smartcampus.entity.ApprovalRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 审批记录表(ApprovalRecord)表数据库访问层
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@Mapper
public interface ApprovalRecordDao {

    /**
     * 查询审批记录列表
     * @return List<ApprovalRecord>
     */
    List<ApprovalRecord> getApprovalRecordList(ApprovalRecordReq dto);

    /**
     * 根据userId查询
     * @param id
     * @return ApprovalRecord
     */
    ApprovalRecord queryByUserId(String id);

    /**
     * 编辑审批记录
     * @param dto
     * @return void
     */
    Integer editApprovalRecord(ApprovalRecord dto);

}

