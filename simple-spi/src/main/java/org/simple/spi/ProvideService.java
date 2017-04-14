package org.simple.spi;

import org.simple.entity.DemoEntity;

public interface ProvideService {
	
	public String getProviceDemo(String name);
	
	public String getProviceToCustomerDemo(String name);
	
	public String getFromCustomerDemo(String name);
	
	public void save(DemoEntity entity);
}
