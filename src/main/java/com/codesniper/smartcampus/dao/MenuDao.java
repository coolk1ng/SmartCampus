package com.codesniper.smartcampus.dao;

import com.codesniper.smartcampus.entity.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单表(Menu)表数据库访问层
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@Mapper
public interface MenuDao {

    /**
     * 根据用户id查询菜单列表
     * @param userId
     * @return List<Menu>
     */
    List<Menu> getMenusByUserId(String userId);

}

