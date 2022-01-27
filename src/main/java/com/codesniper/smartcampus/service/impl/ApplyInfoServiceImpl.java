package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.dao.ApplyInfoDao;
import com.codesniper.smartcampus.dao.UserInfoDao;
import com.codesniper.smartcampus.dto.ApplyRecordReq;
import com.codesniper.smartcampus.entity.ApplyInfo;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.entity.UserInfo;
import com.codesniper.smartcampus.service.ApplyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * 用户申请信息表(ApplyInfo)表服务实现类
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@Service("applyInfoService")
public class ApplyInfoServiceImpl implements ApplyInfoService {

    @Autowired
    private ApplyInfoDao applyInfoDao;
    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public PageInfo<ApplyInfo> getApplyRecordList(ApplyRecordReq dto) {
        PageHelper.startPage(dto.getPageNum()==null ? 1 :dto.getPageNum(),dto.getPageSize()==null ? 10 :dto.getPageSize());
        String userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setUserId(userId);
        return new PageInfo<>(applyInfoDao.getApplyRecordList(dto));
    }

    @Override
    public ApplyInfo getApplyRecordDetail(String id) {
        return applyInfoDao.getApplyRecordDetail(id);
    }

    @Override
    public void InsertToApplication(ApplyInfo dto) {
        String userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        UserInfo userInfo = userInfoDao.queryById(userId);
        dto.setId(UUID.randomUUID().toString().replaceAll("-",""));
        dto.setApplyNo(UUID.randomUUID().toString().replaceAll("-",""));
        dto.setUserId(userId);
        dto.setApplyState("1");
        dto.setApplyTime(new Date());
        dto.setCreateTime(new Date());
        dto.setUpdateTime(new Date());
        //设置用户的上级管理员id
        dto.setManagerId(userInfo.getManagerId());
        applyInfoDao.InsertToApplication(dto);
    }
}
