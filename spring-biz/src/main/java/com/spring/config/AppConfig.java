package com.spring.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/***
 * spring base 配置
 * 
 * @author banxia
 * @date 2016年4月19日 下午3:38:18
 */
@Configuration
@Import(value={SessionConfig.class,RedisConfig.class})
@PropertySource(value={"classpath:app.properties"})
@ComponentScan(basePackages={"com.spring"})
public class AppConfig {

	
}
