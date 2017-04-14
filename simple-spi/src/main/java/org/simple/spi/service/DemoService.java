package org.simple.spi.service;

import org.simple.spi.entity.DemoEntity;

/**
 * 测试用 demo
 * @author John
 *
 */
public interface DemoService {
	
	String getName(String str);
	
	void save(DemoEntity entity);
}
