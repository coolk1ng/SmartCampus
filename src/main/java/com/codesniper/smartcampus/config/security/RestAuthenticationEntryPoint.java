package com.codesniper.smartcampus.config.security;


import com.codesniper.smartcampus.base.ResResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 未登录或token失效时访问接口,自定义返回结果
 *
 * @author CodeSniper
 * @since 2022-01-09
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("application/json");
        PrintWriter writer = httpServletResponse.getWriter();
        ResResult fail = ResResult.fail("未登录,请登录");
        fail.setErrorCode("401");
        writer.write(new ObjectMapper().writeValueAsString(fail));
        writer.flush();
        writer.close();
    }
}
