package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.dao.ApplyInfoDao;
import com.codesniper.smartcampus.dto.ApplyRecordReq;
import com.codesniper.smartcampus.entity.ApplyInfo;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.service.ApplyInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;

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
}
