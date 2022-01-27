package com.codesniper.smartcampus.entity;

import java.util.Date;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户健康状况(UserHealth)实体类
 *
 * @author xwgong4
 * @since 2022-01-27 15:28:23
 */
@Data
@ApiModel("用户健康状况")
public class UserHealth implements Serializable {
    private static final long serialVersionUID = -50911092130684516L;
    /**
     * 主键ID
     */
    @ApiModelProperty("主键ID")
    private String id;

    /**
     * 用户ID
     */
    @ApiModelProperty("用户ID")
    private String userId;

    /**
     * 体温
     */
    @ApiModelProperty("体温")
    private String temperature;

    /**
     * 是否发热
     */
    @ApiModelProperty("是否发热")
    private String isFever;

    /**
     * 是否接触高风险人群
     */
    @ApiModelProperty("是否接触高风险人群")
    private String isContactRisk;

    /**
     * 健康码颜色
     */
    @ApiModelProperty("健康码颜色")
    private String healthCodeColor;

    /**
     * 今天所在地
     */
    @ApiModelProperty("今天所在地")
    private String localToday;

    /**
     * 是否属实
     */
    @ApiModelProperty("是否属实")
    private String isTrue;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("更新时间")
    private Date updateTime;

    private String name;

}

