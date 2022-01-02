package com.codesniper.smartcampus.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 菜单表(Menu)实体类
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@Data
@ApiModel("菜单表")
public class Menu implements Serializable {
    private static final long serialVersionUID = -41267410868079899L;
    /**
     * 菜单表
     */
    private String id;
    /**
     * 菜单ID
     */
    private Integer menuId;
    /**
     * url
     */
    private String url;
    /**
     * 路由路径
     */
    private String path;
    /**
     * 路由组件名
     */
    private String component;
    /**
     * 名称
     */
    private String name;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 上级ID
     */
    private Integer parentId;
    /**
     * 是否启用
     */
    private String enable;


}

