package org.simple.spi;

import org.simple.entity.DemoEntity;

public interface CustomerService {
	
	public String getCustomerDemo(String name);
	
	public String getCustomerToProviceDemo(String name);
	
	public String getFromProviceDemo(String name);
	
	public void save(DemoEntity entity);
}
