package com.spring.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/***
 * apache shiro config
 * @author banxia
 * @date   2016年5月4日 下午8:18:37
 */
@Configuration
public class ShiroConfig {
	
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(){
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setLoginUrl("/login.jsp");
		shiroFilterFactoryBean.setSuccessUrl("/index.jsp");
		shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized.jsp");
		Map<String, String> filterChainDefinitionMap = new HashMap<String, String>();
		filterChainDefinitionMap.put("/admin/**", "authc");
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		return shiroFilterFactoryBean;
	}
	
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager =new DefaultWebSecurityManager();
		securityManager.setRealm(this.realm());
		return securityManager;
	}
	
	@Bean
	public Realm realm(){
		SimpleAccountRealm accountRealm = new SimpleAccountRealm("accountRealm");
		accountRealm.addAccount("admin", "admin");
		accountRealm.addRole("admin");
		accountRealm.addRole("guest");
		accountRealm.addRole("user");
		accountRealm.addAccount("guest", "guest");
		accountRealm.addAccount("user", "user");
		return accountRealm;
	}
	
	
	@Bean
	public LifecycleBeanPostProcessor beanPostProcessor() {
		LifecycleBeanPostProcessor beanPostProcessor = new LifecycleBeanPostProcessor();
		return beanPostProcessor;
	}
	@Bean
	@DependsOn(value={"beanPostProcessor"})
	public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		return advisorAutoProxyCreator;
	}
	
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
		AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
		advisor.setSecurityManager(this.securityManager());
		return advisor;
	}
	
}
