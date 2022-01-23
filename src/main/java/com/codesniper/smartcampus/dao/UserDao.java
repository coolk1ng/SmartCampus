package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.entity.User;
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

}

