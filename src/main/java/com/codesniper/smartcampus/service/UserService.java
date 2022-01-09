package com.codesniper.smartcampus.service;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户表(User)表服务接口
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
public interface UserService {

    /**
     * 登录后返回token
     * @param username
     * @param password
     * @param code
     * @param httpServletRequest
     * @return ResResult
     */
    ResResult login(String username, String password, String code, HttpServletRequest httpServletRequest);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return User
     */
    User getUserInfoByUsername(String username);
}
