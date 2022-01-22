package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.dto.StudentManageReq;
import com.codesniper.smartcampus.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户信息表(UserInfo)表数据库访问层
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@Mapper
public interface UserInfoDao {

    /**
     * 查询学生列表
     * @param dto
     * @return List<UserInfo>
     */
    List<UserInfo> getStudentList(StudentManageReq dto);

    /**
     * 根据id查询
     * @param userId
     * @return UserInfo
     */
    UserInfo queryById(String userId);

    /**
     * 新增
     * @param dto
     * @return void
     */
    void addStudentInfo(UserInfo dto);
}

