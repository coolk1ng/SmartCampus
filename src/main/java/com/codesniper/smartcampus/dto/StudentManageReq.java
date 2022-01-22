package com.codesniper.smartcampus.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 学生管理查询参数
 *
 * @author CodeSniper
 * @since 2022-01-23
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(value = "学生管理查询参数")
public class StudentManageReq extends PageParams{

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别")
    private String sex;

    /**
     * 班级
     */
    @ApiModelProperty(value = "班级")
    private String className;

    /**
     * 上级管理员id
     */
    private String managerId;
}
