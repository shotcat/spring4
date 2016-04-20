package com.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/***
 * 配置
 * 
 * @author banxia
 * @date 2016年4月19日 下午3:38:18
 */
@Configuration
@Import(value={ContextConfig.class})
@PropertySource(value={"classpath:app.properties"})
@ComponentScan(basePackages={"com.spring"})
public class AppConfig {

	
}