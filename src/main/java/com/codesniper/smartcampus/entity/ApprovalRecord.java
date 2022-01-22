package com.codesniper.smartcampus.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.*;
import lombok.Data;

/**
 * 审批记录表(ApprovalRecord)实体类
 *
 * @author CodeSniper
 * @since 2022-01-21 23:36:36
 */
@Data
@ApiModel("审批记录表")
public class ApprovalRecord implements Serializable {
    private static final long serialVersionUID = -17658138632014512L;
    /**
     * 主键ID
     */     
    private String id; 
    /**
     * 用户ID
     */     
    private String userId; 
    /**
     * 姓名
     */     
    private String name; 
    /**
     * 审批人
     */     
    private String approvalPerson;
    /**
     * 审批结果
     */     
    private String approvalResult; 
    /**
     * 审批时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date approvalTime; 
    /**
     * 批准或驳回原因
     */     
    private String approvalReason; 
    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime; 
    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime; 











}

