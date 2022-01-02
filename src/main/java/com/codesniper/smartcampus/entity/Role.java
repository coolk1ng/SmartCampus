package com.codesniper.smartcampus.entity;

import java.io.Serializable;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 角色表(Role)实体类
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@Data
@ApiModel("角色表")
public class Role implements Serializable {
    private static final long serialVersionUID = 955114073756174392L;
    /**
     * 主键ID
     */
    private String id;
    /**
     * 角色ID
     */
    private Integer roleId;
    /**
     * 角色code
     */
    private String roleCode;
    /**
     * 角色名称
     */
    private String roleName;


}

