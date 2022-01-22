package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.dao.UserInfoDao;
import com.codesniper.smartcampus.dto.StudentManageReq;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.entity.UserInfo;
import com.codesniper.smartcampus.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 用户信息表(UserInfo)表服务实现类
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    public PageInfo<UserInfo> getStudentList(StudentManageReq dto) {
        PageHelper.startPage(dto.getPageNum()==null ? 1 : dto.getPageNum(),dto.getPageSize()==null ? 10 : dto.getPageSize());
        String managerId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setManagerId(managerId);
        return new PageInfo<>(userInfoDao.getStudentList(dto));
    }
}
