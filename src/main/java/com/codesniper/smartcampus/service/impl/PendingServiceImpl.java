package com.codesniper.smartcampus.service.impl;


import com.codesniper.smartcampus.dao.ApplyInfoDao;
import com.codesniper.smartcampus.dao.PendingDao;
import com.codesniper.smartcampus.dto.PendingReq;
import com.codesniper.smartcampus.entity.ApplyInfo;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.service.PendingService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * 待审批ServiceImpl
 *
 * @author CodeSniper
 * @since 2022-01-22
 */
@Service("PendingService")
public class PendingServiceImpl implements PendingService {

    @Autowired
    private PendingDao pendingDao;

    @Override
    public PageInfo<ApplyInfo> getPendingList(PendingReq dto) {
        PageHelper.startPage(dto.getPageNum()==null ? 1 : dto.getPageNum(),dto.getPageSize()==null ? 10 : dto.getPageSize());
        String managerId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setManagerId(managerId);
        return new PageInfo<>(pendingDao.getPendingList(dto));
    }

    @Override
    @Transactional
    public void approveApplication(PendingReq dto) {
        String managerId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setId(UUID.randomUUID().toString().replaceAll("-",""));
        dto.setApprovalPerson(managerId);
        dto.setCreateTime(new Date());
        dto.setUpdateTime(new Date());
        dto.setApprovalTime(new Date());
        //设置申请状态-已审批
        dto.setApplyState("0");
        //设置proNo
        pendingDao.approveApplication(dto);
        //插入到审批记录表中
        pendingDao.insertApprovalRecord(dto);
    }

    @Override
    public ApplyInfo getPendingDetail(String id) {
        return pendingDao.queryByUserId(id);
    }
}
