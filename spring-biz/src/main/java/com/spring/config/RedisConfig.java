package com.spring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.RedisOperationsSessionRepository;

/***
 * redis config
 * @author banxia
 * @date   2016年4月22日 下午3:50:28
 */
@Configuration
public class RedisConfig {
	
	
	
	/***
	 * config a jedisConnectionFactory
	 * banxia
	 * 2016年4月22日 下午7:37:50
	 * @return
	 */
	@Bean
	public JedisConnectionFactory jedisConnFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
	    jedisConnectionFactory.setHostName("localhost");
	    jedisConnectionFactory.setPort(6379);
		return jedisConnectionFactory;
	}

	
	
}
