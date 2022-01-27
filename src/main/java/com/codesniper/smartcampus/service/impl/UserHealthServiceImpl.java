package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.dto.UserHealthReq;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.entity.UserHealth;
import com.codesniper.smartcampus.dao.UserHealthDao;
import com.codesniper.smartcampus.service.UserHealthService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;


/**
 * 用户健康状况(UserHealth)表服务实现类
 *
 * @author xwgong4
 * @since 2022-01-27 15:28:24
 */
@Service("userHealthService")
public class UserHealthServiceImpl implements UserHealthService {

    @Autowired
    private UserHealthDao userHealthDao;

    @Override
    public PageInfo<UserHealth> getUserHealthList(UserHealthReq dto) {
        PageHelper.startPage(dto.getPageNum()==null ? 1 :dto.getPageNum(),dto.getPageSize()==null ? 10:dto.getPageSize());
        String userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setUserId(userId);
        return new PageInfo<>(userHealthDao.getUserHealthList(dto));
    }

    @Override
    public UserHealth getUserHealthDetail(String id) {
        return userHealthDao.getUserHealthDetail(id);
    }

    @Override
    public void updateUserHealth(UserHealth dto) {
        dto.setUpdateTime(new Date());
        userHealthDao.updateUserHealth(dto);
    }
}
