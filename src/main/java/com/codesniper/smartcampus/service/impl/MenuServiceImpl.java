package com.codesniper.smartcampus.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.dao.MenuDao;
import com.codesniper.smartcampus.entity.Menu;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单表(Menu)表服务实现类
 *
 * @author CodeSniper
 * @since 2022-01-03 02:11:47
 */
@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public List<Menu> getMenuByUserId() {
        Integer id = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        String redisKey = "menu_"+id;
        if (null == id) {
            return null;
        } else {
            //redis不存在key
            if (Boolean.FALSE.equals(redisTemplate.hasKey(redisKey))) {
                List<Menu> menus = menuDao.getMenusByUserId(id);
                operations.set(redisKey,menus);
                return menus;
            } else {
                //存在key
                return (List<Menu>) operations.get(redisKey);
            }
        }
    }
}
