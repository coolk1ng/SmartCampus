package com.codesniper.smartcampus.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 风险地区参数
 *
 * @author CodeSniper
 * @since 2022-01-29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "风险地区")
public class RiskAreaReq extends PageParams{

    private String id;

    /**
     * 地区
     */
    @ApiModelProperty(value = "地区")
    private String area;

    /**
     * 风险等级
     */
    @ApiModelProperty(value = "风险等级")
    private String riskLevel;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
