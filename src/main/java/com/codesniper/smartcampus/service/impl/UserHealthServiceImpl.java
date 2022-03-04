package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.config.DicConfig;
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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


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
        PageHelper.startPage(dto.getPageNum() == null ? 1 : dto.getPageNum(), dto.getPageSize() == null ? 10 : dto.getPageSize());
        String userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setUserId(userId);
        List<UserHealth> list = userHealthDao.getUserHealthList(dto);
        //映射字典值
        for (UserHealth item : list) {
            item.setIsFever(DicConfig.YES_AND_NO_MAP.get(item.getIsFever()));
            item.setHealthCodeColor(DicConfig.HEALTH_CODE_COLOR_MAP.get(item.getHealthCodeColor()));
            item.setIsContactRisk(DicConfig.YES_AND_NO_MAP.get(item.getIsContactRisk()));
            item.setIsTrue(DicConfig.YES_AND_NO_MAP.get(item.getIsTrue()));
        }
        return new PageInfo<>(list);
    }

    @Override
    public UserHealth getUserHealthDetail(String id) {
        UserHealth item = userHealthDao.getUserHealthDetail(id);
        return item;
    }

    @Override
    @Transactional
    public void updateUserHealth(UserHealth dto) {
        dto.setUpdateTime(new Date());
        userHealthDao.updateUserHealth(dto);
    }

    @Override
    public PageInfo<UserHealth> getHealthListByManager(UserHealthReq dto) {
        PageHelper.startPage(dto.getPageNum() == null ? 1 : dto.getPageNum(), dto.getPageSize() == null ? 10 : dto.getPageSize());
        String managerId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setManagerId(managerId);
        List<UserHealth> list = userHealthDao.getHealthListByManager(dto);
        //映射字典值
        for (UserHealth item : list) {
            item.setHealthCodeColor(DicConfig.HEALTH_CODE_COLOR_MAP.get(item.getHealthCodeColor()));
            item.setIsFever(DicConfig.YES_AND_NO_MAP.get(item.getIsFever()));

        }
        return new PageInfo<>(list);
    }

    @Override
    @Transactional
    public ResResult InsertHealthInfo(UserHealth dto) {
        String userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        if (null != userHealthDao.getHealthInfoToday(userId)) {
            return ResResult.fail("今日已填报");
        }
        dto.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        dto.setUserId(userId);
        dto.setCreateTime(new Date());
        dto.setUpdateTime(new Date());
        userHealthDao.InsertHealthInfo(dto);
        return ResResult.success("填报成功");
    }

}
