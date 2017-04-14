package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.simple.spi.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.JsonResult;

@Controller
@RequestMapping(value = "/dubboTest", method = RequestMethod.POST)
public class DubboTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(DubboTest.class);
	
	@Autowired
	DemoService customerService;
	
	@Autowired
	DemoService privodeService;
	
	@RequestMapping(value = "/getCus1", method = RequestMethod.POST)
	public @ResponseBody JsonResult getCus1(HttpServletRequest request) {
		try {
			String str = customerService.getName("张三");
			String str2 = privodeService.getName("lisi");
			return new JsonResult(str);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}

	
}
