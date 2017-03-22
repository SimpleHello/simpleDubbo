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
@RequestMapping(value = "/dubboTest", method = RequestMethod.POST)
public class DubboTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(DubboTest.class);
	
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
	
	@RequestMapping(value = "/getCus2", method = RequestMethod.POST)
	public @ResponseBody JsonResult getCus2(HttpServletRequest request) {
		try {
			String str = customerDb.getFromProviceDemo("getCus2");
			return new JsonResult(str);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/getPro1", method = RequestMethod.POST)
	public @ResponseBody JsonResult getPro1(HttpServletRequest request) {
		try {
			String str = privodeDb.getProviceDemo("getPro1");
			return new JsonResult(str);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
	@RequestMapping(value = "/getPro2", method = RequestMethod.POST)
	public @ResponseBody JsonResult getPro2(HttpServletRequest request) {
		try {
			String str = privodeDb.getFromCustomerDemo("getPro2");
			return new JsonResult(str);
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
			return new JsonResult("服务器产生未知异常，请稍后再试。", false);
		}
	}
	
}
