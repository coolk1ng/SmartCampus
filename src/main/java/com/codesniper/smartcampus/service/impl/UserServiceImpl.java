package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.config.security.JwtTokenUtil;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.dao.UserDao;
import com.codesniper.smartcampus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import springfox.documentation.spi.service.contexts.SecurityContext;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * 用户表(User)表服务实现类
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public ResResult login(String username, String password, HttpServletRequest httpServletRequest) {
        //根据用户名获取userDetails
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null==userDetails || !passwordEncoder.matches(password,userDetails.getPassword())){
            return ResResult.fail("用户名或密码不正确");
        }
        if (!userDetails.isEnabled()){
            return ResResult.fail("该账户被禁用");
        }
        //更新security登录对象
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //返回token
        String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, String> map = new HashMap<>();
        map.put("token",token);
        map.put("tokenHead",tokenHead);
        return ResResult.success("登录成功",map);
    }

    @Override
    public User getUserInfoByUsername(String username) {
        return userDao.getUserInfoByUsername(username);
    }
}
