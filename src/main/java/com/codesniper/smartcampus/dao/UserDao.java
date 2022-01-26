package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表(User)表数据库访问层
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@Mapper
public interface UserDao {

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return User
     */
    User getUserInfoByUsername(String username);

    /**
     * 新增
     * @param dto
     * @return void
     */
    void addUserInfo(User dto);

    /**
     * 编辑
     * @param dto
     * @return void
     */
    void editUserInfo(User dto);

    /**
     * 根据userId查询个人信息
     * @param userId
     * @return UserInfo
     */
    UserInfo getPersonalInfo(String userId);

    /**
     * 编辑user表信息
     * @param dto
     * @return void
     */
    void updateUser(User dto);

    /**
     * 编辑userinfo
     * @param dto
     * @return void
     */
    void updateUserInfo(UserInfo dto);

}

