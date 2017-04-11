package org.simple.customer;

import org.simple.spi.CustomerService;
import org.simple.spi.ProvideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service("customerDb")
public class CustomerDb implements CustomerService{

	@Autowired
	ProvideService privodeDb;
	
	
	@Override
	public String getCustomerDemo(String name) {
		// TODO Auto-generated method stub
		return "customer 提供:"+ name;
	}

	@Override
	public String getCustomerToProviceDemo(String name) {
		// TODO Auto-generated method stub
		return "customer 提供pro:"+ name;
	}

	@Override
	public String getFromProviceDemo(String name) {
		// TODO Auto-generated method stub
		String str = privodeDb.getProviceToCustomerDemo(name);
		return "经过 获取："+str;
	}

}
