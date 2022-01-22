package com.codesniper.smartcampus.dto;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 审批记录查询参数
 *
 * @author CodeSniper
 * @since 2022-01-22
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApprovalRecordReq extends PageParams{

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 审批结果
     */
    @ApiModelProperty(value = "审批结果")
    private String approvalResult;

    /**
     * 审批人
     */
    @ApiModelProperty(value = "审批人")
    private String approvalPerson;
}
