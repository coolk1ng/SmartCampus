package com.codesniper.smartcampus.controller;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * 菜单表(Menu)表控制层
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@RestController
@Api(tags = "菜单")
@RequestMapping(value = "/menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;

    @PostMapping(value = "/getMenusByUserId")
    @ApiOperation(value = "根据用户id查询菜单")
    public ResResult getMenusByUserId(){
        return ResResult.success(menuService.getMenuByUserId());
    }

}

