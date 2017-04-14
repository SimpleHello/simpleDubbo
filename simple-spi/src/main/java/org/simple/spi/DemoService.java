package org.simple.spi;

import org.simple.entity.DemoEntity;

public interface DemoService {
	public String getDemo(String name);
	
	void save(DemoEntity entity);
}
