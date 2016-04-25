package com.spring.config;


import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.config.annotation.web.http.SpringHttpSessionConfiguration;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;

/***
 * spring session config
 * @author banxia
 * @date   2016年4月22日 下午3:48:29
 */
@Configuration
@Import(value={SpringHttpSessionConfiguration.class})
@EnableRedisHttpSession
public class SessionConfig {
	
	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;
	
	 
	 
	 @Bean
	 public RedisHttpSessionConfiguration  redisHttpSessionConfiguration() {
		   RedisHttpSessionConfiguration redisHttpSessionConfiguration = new RedisHttpSessionConfiguration();
		   redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(60*30);
		   return redisHttpSessionConfiguration;
	 }
	 
	 @Bean
	 public RedisOperationsSessionRepository sessionRepository() {
		 return new RedisOperationsSessionRepository(jedisConnectionFactory);
	 }
	
	 @Bean
	 public ConcurrentTaskScheduler concurrentTaskScheduler() {
		  ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(5);
		 return new ConcurrentTaskScheduler(threadPool);
	 }
	
}
