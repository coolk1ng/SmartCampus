package com.codesniper.smartcampus.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息表(UserInfo)实体类
 *
 * @author CodeSniper
 * @since 2022-01-21 23:36:18
 */
@Data
@ApiModel("用户信息表")
public class UserInfo implements Serializable {
    private static final long serialVersionUID = -77771762699728584L;
    /**
     * 主键ID
     */     
    private String id; 
    /**
     * 用户ID
     */     
    private String userId;
    /**
     * 学号
     */
    private String studentId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */     
    private String sex; 
    /**
     * 学院
     */     
    private String college; 
    /**
     * 个人联系方式
     */     
    private String telephone; 
    /**
     * 身份证号
     */     
    private String idCardNum; 
    /**
     * 户籍地
     */     
    private String domicile;
    /**
     * 角色编码
     */
    private String roleId;
    /**
     * 上级管理员用户编码
     */
    private String managerId;
    /**
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthTime; 
    /**
     * 父亲联系方式
     */     
    private String fatherTel; 
    /**
     * 母亲联系方式
     */     
    private String motherTel; 
    /**
     * 政治面貌code
     */     
    private String politicalStatus;

    //政治面貌value
    private String politicalStatusValue;
    /**
     * 年龄
     */     
    private String age; 
    /**
     * 任职情况code
     */
    private String cognition;
    /**
     * 任职情况value
     */
    private String cognitionValue;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime; 
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime;
    /**
     * 班级
     */     
    private String className;
    /**
     * 名族
     */
    private String clan;
    /**
     * 入学时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date enterTime;
    /**
     * 专业
     */
    private String professional;
    /**
     * 备注
     */
    private String remark;

    private String userName;

    private String password;

    private String currentAddress;

    /**
     * 性别value
     */
    private String sexValue;
}

