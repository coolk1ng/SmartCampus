package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.config.DicConfig;
import com.codesniper.smartcampus.dao.ApprovalRecordDao;
import com.codesniper.smartcampus.dao.UserInfoDao;
import com.codesniper.smartcampus.dto.ApprovalRecordReq;
import com.codesniper.smartcampus.entity.ApprovalRecord;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.entity.UserInfo;
import com.codesniper.smartcampus.service.ApprovalRecordService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

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
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public PageInfo<ApprovalRecord> getApprovalRecordList(ApprovalRecordReq dto) {
        PageHelper.startPage(dto.getPageNum()==null ? 1 : dto.getPageNum(),dto.getPageSize()==null ? 10 : dto.getPageSize());
        //审批人
        String userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        UserInfo userInfo = userInfoDao.queryById(userId);
        dto.setApprovalPerson(userId);
        List<ApprovalRecord> list = approvalRecordDao.getApprovalRecordList(dto);
        //设置字典值
        for (ApprovalRecord item : list) {
            item.setApprovalPerson(userInfo.getName());
            item.setApprovalResult(DicConfig.APPROVAL_RESULT_MAP.get(item.getApprovalResult()));
        }
        return new PageInfo<>();
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
