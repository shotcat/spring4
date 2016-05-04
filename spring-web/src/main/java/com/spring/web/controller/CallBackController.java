package com.spring.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/callback")
public class CallBackController {

	
	private static  Logger logger = Logger.getLogger(CallBackController.class);
	
	
	@RequestMapping("/bootActiveSpread")
	@ResponseBody
	public Map<String, Object> bootActiveSpread() {
		Map<String, Object> param = new HashMap<String, Object>();
		logger.info("into the bootActiveSpread method ...");
		param.put("success", true);
		return param;
	}
}
