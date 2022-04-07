package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.dto.StudentManageReq;
import com.codesniper.smartcampus.dto.UserMenu;
import com.codesniper.smartcampus.dto.UserRoleDto;
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
     */
    void addStudentInfo(UserInfo dto);

    /**
     * 编辑
     * @param dto
     */
    void editStudentInfo(UserInfo dto);

    /**
     * 批量删除
     * @param arr
     * @return void
     */
    void deleteStudentInfo(String[] arr);

    /**
     * 新增用户权限
     * @param dto
     * @return void
     */
    void addUserRole(UserRoleDto dto);

    /**
     * 新增用户新增菜单
     * @param dto
     * @return void
     */
    void addMenusForUser(UserMenu dto);

    /**
     * 删除MenuRole表
     * @param arr
     * @return void
     */
    void deleteMenuRole(String[] arr);

    /**
     * 删除User表
     * @param arr
     * @return void
     */
    void deleteUser(String[] arr);

    /**
     * 删除UserRole表
     * @param arr
     * @return void
     */
    void deleteUserRole(String[] arr);
}

