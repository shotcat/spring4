package com.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;

/***
 * spring session config
 * @author banxia
 * @date   2016年4月22日 下午3:48:29
 */
@Configuration
@EnableSpringHttpSession
public class SessionConfig {
	
	
	 @Bean
     public MapSessionRepository sessionRepository() {
         return new MapSessionRepository();
     }
	
	
}
