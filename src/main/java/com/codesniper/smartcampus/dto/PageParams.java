package com.codesniper.smartcampus.dto;


import lombok.Data;

/**
 * 分页参数
 *
 * @author CodeSniper
 * @since 2022-01-22
 */
@Data
public class PageParams {

    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 数量
     */
    private Integer pageSize;
}
