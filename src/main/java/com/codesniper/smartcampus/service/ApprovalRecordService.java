package com.codesniper.smartcampus.service;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.ApprovalRecordReq;
import com.codesniper.smartcampus.entity.ApprovalRecord;
import com.github.pagehelper.PageInfo;

/**
 * 审批记录表(ApprovalRecord)表服务接口
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
public interface ApprovalRecordService {

    /**
     * 查询审批记录
     * @param dto
     * @return PageInfo<ApprovalRecord>
     */
    PageInfo<ApprovalRecord> getApprovalRecordList(ApprovalRecordReq dto);

    /**
     * 查询详情
     * @param applyNo
     * @return ApprovalRecord
     */
    ApprovalRecord getDetail(String applyNo);

    /**
     * 编辑审批记录
     * @param dto
     * @return void
     */
    ResResult editApprovalRecord(ApprovalRecord dto);
}
