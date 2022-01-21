package com.codesniper.smartcampus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户信息表(UserInfo)表控制层
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@RestController
@RequestMapping(value = "/userInfo")
public class UserInfoController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserInfoController.class);

}

