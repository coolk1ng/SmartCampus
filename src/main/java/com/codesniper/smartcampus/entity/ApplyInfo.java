package com.codesniper.smartcampus.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户申请信息表(ApplyInfo)实体类
 *
 * @author CodeSniper
 * @since 2022-01-21 23:36:36
 */
@Data
@ApiModel("用户申请信息表")
public class ApplyInfo implements Serializable {
    private static final long serialVersionUID = -51112397247752554L;
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
     * 申请原因
     */     
    private String applyReason;
    /**
     * 姓名
     */
    private String name;
    /**
     * 离校时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leaveTime; 
    /**
     * 返校时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date returnTime; 
    /**
     * 离校具体天数
     */     
    private String days; 
    /**
     * 家庭住址
     */     
    private String homeAddress; 
    /**
     * 监护人联系方式
     */     
    private String guardianTel; 
    /**
     * 交通工具
     */     
    private String trafficType; 
    /**
     * 交通工具班次
     */     
    private String trafficNum; 
    /**
     * 管理员ID
     */     
    private String managerId; 
    /**
     * 申请状态
     */     
    private String applyState;
    /**
     * 申请时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date applyTime;
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
     * 体温
     */
    private String temperature;

    /**
     * 是否发热
     */
    private String isFever;

    /**
     * 是否接触高风险人群
     */
    private String isContactRisk;

    /**
     * 健康码颜色
     */
    private String healthCodeColor;

    /**
     * 是否属实
     */
    private String isTrue;

    /**
     * 审批的原因
     */
    private String approvalReason;

    /**
     * 逻辑删除
     */
    private String isDelete;
}

