package com.codesniper.smartcampus.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author xwgong4
 * @description 申请记录参数
 * @since 2022-01-25 15:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "申请记录参数")
public class ApplyRecordReq extends PageParams{

    /**
     * 用户id
     */
    private String userId;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 离校时间
     */
    @ApiModelProperty(value = "离校时间")
    private Date leaveTime;

    /**
     * 返校时间
     */
    @ApiModelProperty(value = "返校时间")
    private Date returnTime;
}
