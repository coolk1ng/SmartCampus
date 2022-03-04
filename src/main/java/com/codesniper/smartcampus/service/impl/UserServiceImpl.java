package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.config.DicConfig;
import com.codesniper.smartcampus.config.security.JwtTokenUtil;
import com.codesniper.smartcampus.dao.UserDao;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.entity.UserInfo;
import com.codesniper.smartcampus.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public ResResult login(String username, String password, String code, HttpServletRequest httpServletRequest) {
        //校验验证码
        String captcha = (String) httpServletRequest.getSession().getAttribute("captcha");
        if (StringUtils.isBlank(captcha) || !captcha.equalsIgnoreCase(code)){
            return ResResult.fail("验证码错误,请重新输入!");
        }
        //根据用户名获取userDetails
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null==userDetails || !passwordEncoder.matches(password,userDetails.getPassword())){
            return ResResult.fail("用户名或密码不正确!");
        }
        if (!userDetails.isEnabled()){
            return ResResult.fail("该账户被禁用!");
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

    @Override
    public UserInfo getPersonalInfo(String userId) {
        String id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        UserInfo personalInfo = userDao.getPersonalInfo(id);
        personalInfo.setSexValue(DicConfig.GENDER_MAP.get(personalInfo.getSex()));
        personalInfo.setPoliticalStatusValue(DicConfig.POLITICAL_STATUS_MAP.get(personalInfo.getPoliticalStatus()));
        personalInfo.setCognitionValue(DicConfig.JOB_LEVEL_MAP.get(personalInfo.getCognition()));
        return personalInfo;
    }

    @Override
    @Transactional
    public ResResult updatePersonalInfo(UserInfo dto) {
        String redisKey = "menu_";
        if (StringUtils.isBlank(dto.getUserId())){
            return ResResult.fail("不存在的用户");
        }
        User user = new User();
        user.setUserId(dto.getUserId());
        user.setUsername(dto.getUserName());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setName(dto.getName());
        //编辑User表
        userDao.updateUser(user);

        //编辑UserInfo表
        dto.setUpdateTime(new Date());
        userDao.updateUserInfo(dto);

        //删除redis中的key
        redisTemplate.delete(redisKey + dto.getUserId());
        return ResResult.success("编辑成功");
    }

}
