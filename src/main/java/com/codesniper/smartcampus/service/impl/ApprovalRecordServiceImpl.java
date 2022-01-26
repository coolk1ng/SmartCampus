package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dao.ApprovalRecordDao;
import com.codesniper.smartcampus.dto.ApprovalRecordReq;
import com.codesniper.smartcampus.entity.ApprovalRecord;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.service.ApprovalRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;

/**
 * 审批记录表(ApprovalRecord)表服务实现类
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@Service("approvalRecordService")
public class ApprovalRecordServiceImpl implements ApprovalRecordService {

    @Autowired
    private ApprovalRecordDao approvalRecordDao;

    @Override
    public PageInfo<ApprovalRecord> getApprovalRecordList(ApprovalRecordReq dto) {
        PageHelper.startPage(dto.getPageNum()==null ? 1 : dto.getPageNum(),dto.getPageSize()==null ? 10 : dto.getPageSize());
        //审批人
        String userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setApprovalPerson(userId);
        return new PageInfo<>(approvalRecordDao.getApprovalRecordList(dto));
    }

    @Override
    public ApprovalRecord getDetail(String applyNo) {
        return approvalRecordDao.queryByUserId(applyNo);
    }

    @Override
    public ResResult editApprovalRecord(ApprovalRecord dto) {
        ApprovalRecord item = approvalRecordDao.queryByUserId(dto.getUserId());
        if (null==item){
            return ResResult.fail("无此条记录");
        }
        dto.setUpdateTime(new Date());
        return ResResult.success(approvalRecordDao.editApprovalRecord(dto));
    }
}
