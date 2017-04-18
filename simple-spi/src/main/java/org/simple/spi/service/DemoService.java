package org.simple.spi.service;

import java.util.List;

import org.simple.spi.entity.DemoEntity;

/**
 * 测试用 demo
 * @author John
 *
 */
public interface DemoService {
	
	String getName(String str);
	
	void save(DemoEntity entity);
	
	List<String> getList();
}
