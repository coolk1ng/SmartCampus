package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.dto.UserHealthReq;
import com.codesniper.smartcampus.entity.UserHealth;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户健康状况(UserHealth)表数据库访问层
 *
 * @author xwgong4
 * @since 2022-01-27 15:28:23
 */
@Mapper
public interface UserHealthDao {

    /**
     * 健康状况列表
     * @param dto
     * @return List<UserHealth>
     */
    List<UserHealth> getUserHealthList(UserHealthReq dto);

    /**
     * 查询健康状况详情
     * @param id
     * @return UserHealth
     */
    UserHealth getUserHealthDetail(String id);

    /**
     * 更新健康状况
     * @param dto
     * @return void
     */
    void updateUserHealth(UserHealth dto);

    /**
     * 根据managerId查询健康状况列表
     * @param dto
     * @return List<UserHealth>
     */
    List<UserHealth> getHealthListByManager(UserHealthReq dto);

    /**
     * 填报健康信息
     * @param dto
     * @return void
     */
    void insertHealthInfo(UserHealth dto);
    
    /** 
     * 查询该用户当天的健康信息
     * @param userId
     * @return UserHealth
     */ 
    UserHealth getHealthInfoToday(String userId);
}

