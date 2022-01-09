package com.codesniper.smartcampus.config;


import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * 验证码配置类
 *
 * @author CodeSniper
 * @since 2022-01-09
 */
@Configuration
public class CaptchaConfig {

    @Bean
    public DefaultKaptcha defaultKaptcha(){
        Properties properties = new Properties();
        properties.setProperty("Captcha.border","yes");
        properties.setProperty("Captcha.textproducer.font,color","black");
        properties.setProperty("Captcha.textproducer.char.space","5");
        properties.setProperty("Captcha.textproducer.font.names","宋体,楷体,微软雅黑");
        Config config = new Config(properties);
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
