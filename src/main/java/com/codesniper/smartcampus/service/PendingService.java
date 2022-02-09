package com.codesniper.smartcampus.service;


import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.PendingReq;
import com.codesniper.smartcampus.entity.ApplyInfo;
import com.github.pagehelper.PageInfo;

/**
 * 待审批Service
 *
 * @author CodeSniper
 * @since 2022-01-22
 */
public interface PendingService {
    
    /** 
     * 查询待审批列表
     * @param dto 
     * @return PageInfo<ApplyInfo>
     */
    PageInfo<ApplyInfo> getPendingList(PendingReq dto);
    
    /** 
     * 批准,驳回申请
     * @param dto 
     * @return ResResult
     */
    void approveApplication(PendingReq dto);

    /**
     * 查询待审批详情
     * @param id
     * @return ApplyInfo
     */
    ApplyInfo getPendingDetail(String id);
}
