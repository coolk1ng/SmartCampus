package com.codesniper.smartcampus.service;

import com.codesniper.smartcampus.dto.ApplyRecordReq;
import com.codesniper.smartcampus.entity.ApplyInfo;
import com.github.pagehelper.PageInfo;

/**
 * 用户申请信息表(ApplyInfo)表服务接口
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
public interface ApplyInfoService {

    /**
     * 查询申请记录列表
     * @param dto
     * @return PageInfo<ApplyInfo>
     */
    PageInfo<ApplyInfo> getApplyRecordList(ApplyRecordReq dto);

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
    void insertToApplication(ApplyInfo dto);

}
