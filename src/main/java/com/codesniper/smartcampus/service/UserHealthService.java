package com.codesniper.smartcampus.service;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dto.UserHealthReq;
import com.codesniper.smartcampus.entity.UserHealth;
import com.github.pagehelper.PageInfo;

/**
 * 用户健康状况(UserHealth)表服务接口
 *
 * @author xwgong4
 * @since 2022-01-27 15:28:24
 */
public interface UserHealthService {
    
    /** 
     * 查询用户健康列表
     * @param dto
     * @return PageInfo<UserHealth>
     */ 
    PageInfo<UserHealth> getUserHealthList(UserHealthReq dto);

    /**
     * 查询用户健康详情
     * @param id
     * @return UserHealth
     */
    UserHealth getUserHealthDetail(String id);

    /**
     * 编辑健康状况
     * @param dto
     * @return void
     */
    void updateUserHealth(UserHealth dto);

    /**
     * 根据managerId查询健康状况列表
     * @return PageInfo<UserHealth>
     */
    PageInfo<UserHealth> getHealthListByManager(UserHealthReq dto);

    /**
     * 新增填报信息
     * @param dto
     * @return void
     */
    ResResult InsertHealthInfo(UserHealth dto);

}
