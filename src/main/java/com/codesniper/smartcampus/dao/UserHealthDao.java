package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.dto.UserHealthReq;
import com.codesniper.smartcampus.entity.UserHealth;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

}

