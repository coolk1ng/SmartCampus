package com.codesniper.smartcampus.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

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
     * 申请编号
     */
    private String applyNo;
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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date approvalTime; 
    /**
     * 批准或驳回原因
     */     
    private String approvalReason; 
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

    /**
     * 逻辑删除
     */
    private String isDelete;

    /**
     * 管理员名称
     */
    private String approvalPersonName;

}

