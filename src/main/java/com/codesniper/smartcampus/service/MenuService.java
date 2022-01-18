package com.codesniper.smartcampus.service;


import com.codesniper.smartcampus.entity.Menu;

import java.util.List;

/**
 * 菜单表(Menu)表服务接口
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
public interface MenuService {

    /**
     * 查询菜单列表
     * @return List<Menu>
     */
    List<Menu> getMenuByUserId();

}
