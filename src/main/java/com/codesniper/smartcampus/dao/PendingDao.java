package com.codesniper.smartcampus.dao;


import com.codesniper.smartcampus.dto.PendingReq;
import com.codesniper.smartcampus.entity.ApplyInfo;
import com.codesniper.smartcampus.entity.ApprovalRecord;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 待审批Dao
 *
 * @author CodeSniper
 * @since 2022-01-22
 */
@Mapper
public interface PendingDao {

    /**
     * 查询待审批列表
     * @param dto
     * @return List<ApplyInfo>
     */
    List <ApplyInfo> getPendingList(PendingReq dto);

    /**
     * 批准,驳回申请
     * @param applyState
     * @return Integer
     */
    void approveApplication(String applyState);

    /**
     * 插入到审批记录表
     * @param dto
     * @return void
     */
    void insertApprovalRecord(PendingReq dto);

    /**
     * 根据id查询
     * @param userId
     * @return ApplyInfo
     */
    ApplyInfo queryByUserId(String userId);
}
