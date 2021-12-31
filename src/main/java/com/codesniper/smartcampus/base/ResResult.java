package com.codesniper.smartcampus.base;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 公共返回对象
 *
 * @author CodeSniper
 * @since 2022-01-01
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResResult {

    /**
     * 成功/失败状态
     */
    private boolean flag;

    /**
     * 返回的数据
     */
    private Object data;

    /**
     * 错误码
     */
    private String errorCode;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 成功时返回信息
     * @param message
     * @return ResResult
     */
    public static ResResult success(String message){
        return new ResResult(true,null,"-1","success");
    }

    /**
     * 成功时返回信息
     * @param data
     * @return ResResult
     */
    public static ResResult success(Object data){
        return new ResResult(true,data,"-1","success");
    }

    /**
     * 请求失败返回信息
     * @param message
     * @return ResResult
     */
    public static ResResult fail(String message){
        return new ResResult(false,null,"400",message);
    }

    /**
     * 错误时返回信息
     * @param errorCode
     * @param message
     * @param data
     * @return ResResult
     */
    public static ResResult fail(String errorCode,String message, Object data){
        return new ResResult(false,data,errorCode,message);
    }
}
