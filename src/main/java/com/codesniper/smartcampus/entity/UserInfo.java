package com.codesniper.smartcampus.entity;

import java.util.Date;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
     * 性别
     */     
    private String sex; 
    /**
     * 班级
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
     * 出生日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
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
     * 政治面貌
     */     
    private String politicalStatus; 
    /**
     * 年龄
     */     
    private String age; 
    /**
     * 任职情况
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String cognition; 
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime; 
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime; 
    /**
     * 逻辑删除
     */     
    private String isDelete; 
    /**
     * 班级
     */     
    private String className; 



















}

