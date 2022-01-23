package com.codesniper.smartcampus.service;

import com.codesniper.smartcampus.dto.StudentManageReq;
import com.codesniper.smartcampus.entity.UserInfo;
import com.github.pagehelper.PageInfo;

/**
 * 用户信息表(UserInfo)表服务接口
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
public interface UserInfoService {

    /**
     * 查询学生列表
     * @param dto
     * @return PageInfo<UserInfo>
     */
    PageInfo<UserInfo> getStudentList(StudentManageReq dto);

    /**
     * 新增,编辑
     * @param dto
     */
    void addAndEditStudent(UserInfo dto);

    /**
     * 批量删除
     * @param userIds
     * @return void
     */
    void deleteStudentInfo(String userIds);

    /**
     * 查询详情
     * @param userId
     * @return UserInfo
     */
    UserInfo getDetail(String userId);
}
