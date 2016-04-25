package com.spring.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private static final  Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping("/say")
	@ResponseBody
	public String say(HttpServletRequest request){
		Object user = request.getSession().getAttribute("user");
		if (user == null) {
			logger.info("session user is null");
			request.getSession().setAttribute("user", "动态");
		} else {
			logger.info("session user is not  null");
		}
		return "你好";
	}

}
