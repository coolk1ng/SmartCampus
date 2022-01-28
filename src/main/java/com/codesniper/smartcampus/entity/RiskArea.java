package com.codesniper.smartcampus.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * (RiskArea)实体类
 *
 * @author CodeSniper
 * @since 2022-01-29 01:44:10
 */
@Data
@ApiModel("$tableInfo.comment")
public class RiskArea implements Serializable {
    private static final long serialVersionUID = 549530860282102488L;
    /**
     * 主键ID
     */     
    private String id; 
    /**
     * 地区
     */     
    private String area; 
    /**
     * 区划编码
     */     
    private String areaCode; 
    /**
     * 风险等级
     */     
    private String riskLevel; 
    /**
     * 备注
     */     
    private String remark; 
    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date updateTime; 
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime; 









}

