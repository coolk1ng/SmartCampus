package com.codesniper.smartcampus.service.impl;

import com.codesniper.smartcampus.base.ResResult;
import com.codesniper.smartcampus.config.DicConfig;
import com.codesniper.smartcampus.dao.UserDao;
import com.codesniper.smartcampus.dao.UserInfoDao;
import com.codesniper.smartcampus.dto.StudentManageReq;
import com.codesniper.smartcampus.dto.UserMenu;
import com.codesniper.smartcampus.dto.UserRoleDto;
import com.codesniper.smartcampus.entity.User;
import com.codesniper.smartcampus.entity.UserInfo;
import com.codesniper.smartcampus.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 用户信息表(UserInfo)表服务实现类
 *
 * @author CodeSniper
 * @since 2022-01-21 23:31:46
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public PageInfo<UserInfo> getStudentList(StudentManageReq dto) {
        PageHelper.startPage(dto.getPageNum()==null ? 1 : dto.getPageNum(),dto.getPageSize()==null ? 10 : dto.getPageSize());
        String managerId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        dto.setManagerId(managerId);
        List<UserInfo> list = userInfoDao.getStudentList(dto);
        //映射字典值
        for (UserInfo item : list) {
            item.setSex(DicConfig.GENDER_MAP.get(item.getSex()));
        }
        return new PageInfo<>(list);
    }

    @Override
    @Transactional
    public void addAndEditStudent(UserInfo dto) {
        User user = new User();
        UserInfo item = userInfoDao.queryById(dto.getUserId());
        if (StringUtils.isNotBlank(dto.getUserId())){
            if (null==item){
                ResResult.fail("无此条数据");
                return;
            }
            //编辑
            user.setUsername(dto.getStudentId());
            userDao.editUserInfo(user);
            dto.setUpdateTime(new Date());
            userInfoDao.editStudentInfo(dto);
            ResResult.success("编辑成功");
        }else{
            //新增
            String ManagerId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
            //插入用户表
            user.setId(UUID.randomUUID().toString().replaceAll("-",""));
            user.setUserId(UUID.randomUUID().toString().replaceAll("-",""));
            user.setUsername(dto.getStudentId());
            user.setPassword(passwordEncoder.encode(dto.getStudentId()));
            user.setEnabled(true);
            userDao.addUserInfo(user);

            //插入用户信息表
            dto.setId(UUID.randomUUID().toString().replaceAll("-",""));
            dto.setUserId(user.getUserId());
            dto.setManagerId(ManagerId);
            dto.setRoleId("1");
            dto.setCreateTime(new Date());
            dto.setUpdateTime(new Date());
            userInfoDao.addStudentInfo(dto);

            //插入用户角色表
            UserRoleDto userRole = new UserRoleDto();
            userRole.setId(UUID.randomUUID().toString().replaceAll("-",""));
            userRole.setUserId(dto.getUserId());
            userRole.setRoleId("1");
            userInfoDao.addUserRole(userRole);

            //插入角色菜单表
            String[] menus ={"1","2","5","98","99","6"};
            UserMenu userMenu = new UserMenu();
            userMenu.setRoleId("1");
            userMenu.setUserId(user.getUserId());
            for (String menu : menus) {
                userMenu.setId(UUID.randomUUID().toString().replaceAll("-",""));
                userMenu.setMenuId(menu);
                userInfoDao.addMenusForUser(userMenu);
            }
            ResResult.success("新增成功");
        }
    }

    @Override
    @Transactional
    public void deleteStudentInfo(String userIds) {
        String[] ids = userIds.split(",");
        userInfoDao.deleteStudentInfo(ids);
        userInfoDao.deleteMenuRole(ids);
        userInfoDao.deleteUser(ids);
        userInfoDao.deleteUserRole(ids);
    }

    @Override
    public UserInfo getDetail(String userId) {
        UserInfo userInfo = userInfoDao.queryById(userId);
        //字典值
        //userInfo.setSex(DicConfig.GENDER_MAP.get(userInfo.getSex()));
        //userInfo.setPoliticalStatus(DicConfig.POLITICAL_STATUS_MAP.get(userInfo.getPoliticalStatus()));
        //userInfo.setCognition(DicConfig.JOB_LEVEL_MAP.get(userInfo.getCognition()));
        return userInfo;
    }
}
