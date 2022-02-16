package com.codesniper.smartcampus.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;


/**
 * @author xwgong4
 * @description 健康状况参数
 * @since 2022-01-27 15:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserHealthReq extends PageParams{

    private String id;

    private String name;

    private String userId;

    private String isFever;

    private String healthCodeColor;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    private String managerId;

}
