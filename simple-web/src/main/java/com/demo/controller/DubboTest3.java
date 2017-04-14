package com.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.simple.spi.CustomerService;
import org.simple.spi.ProvideService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.common.JsonResult;

@Controller
@RequestMapping(value = "/dubboTest2", method = RequestMethod.POST)
public class DubboTest3 {
	private static final Logger LOGGER = LoggerFactory.getLogger(DubboTest3.class);
	
	@Autowired
	CustomerService customerDb;
	
	@Autowired
	ProvideService privodeDb;
	
	@RequestMapping(value = "/getCus1", method = RequestMethod.POST)
	public @ResponseBody JsonResult getCus1(HttpServletRequest request) {
		try {
			String str = customerDb.getCustomerDemo("getCus1");
			return new JsonResult(str);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
}
