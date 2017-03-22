package org.simple.service;

import org.simple.spi.CustomerService;
import org.simple.spi.ProvideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("privodeDb")
public class PrivodeDb implements ProvideService{

	@Autowired
	CustomerService customerDb;
	
	@Override
	public String getProviceDemo(String name) {
		// TODO Auto-generated method stub
		return "Privode 提供："+name;
	}

	@Override
	public String getProviceToCustomerDemo(String name) {
		// TODO Auto-generated method stub
		return "Privode 提供 cus："+name;
	}

	@Override
	public String getFromCustomerDemo(String name) {
		// TODO Auto-generated method stub
		String str = "经过转:"+ customerDb.getCustomerToProviceDemo(name);
		return str;
	}

}
