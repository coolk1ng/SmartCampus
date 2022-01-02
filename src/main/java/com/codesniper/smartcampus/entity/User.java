package com.codesniper.smartcampus.entity;

import java.io.Serializable;
import java.util.Collection;

import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户表(User)实体类
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@Data
@ApiModel("用户表")
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = -22731510649417986L;
    /**
     * 主键ID
     */
    private String id;
    /**
     * 用户ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 是否启用
     */
    private boolean enabled;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}

