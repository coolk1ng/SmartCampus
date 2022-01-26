package com.codesniper.smartcampus.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 待审批
 *
 * @author CodeSniper
 * @since 2022-01-22
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "待审批查询参数")
public class PendingReq extends PageParams{

    private String id;

    private String userId;

    private String applyNo;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;

    /**
     * 离校时间
     */
    @ApiModelProperty(value = "离校时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date leaveTime;

    /**
     * 返校时间
     */
    @ApiModelProperty(value = "返校时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date returnTime;

    /**
     * 管理员id
     */
    private String managerId;

    /**
     * 申请状态
     */
    private String applyState;

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
    private Date approvalTime;

    /**
     * 批准或驳回原因
     */
    private String approvalReason;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
}
