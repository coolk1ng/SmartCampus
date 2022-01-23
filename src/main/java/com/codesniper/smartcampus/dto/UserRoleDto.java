package com.codesniper.smartcampus.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户权限参数
 *
 * @author CodeSniper
 * @since 2022-01-23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleDto {

    private String id;

    private String userId;

    private String roleId;

    private String menuId;
}
