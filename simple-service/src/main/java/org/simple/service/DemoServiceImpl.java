package org.simple.service;

import org.simple.spi.DemoService;
import org.springframework.stereotype.Service;

@Service("demoService")
public class DemoServiceImpl implements DemoService{

	@Override
	public String getDemo(String name) {
		// TODO Auto-generated method stub
		return "服务端"+name;
	}

}
