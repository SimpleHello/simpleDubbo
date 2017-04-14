package com.demo.service;

import java.util.List;
import java.util.Map;

import org.simple.spi.entity.DemoEntity;

import com.demo.entity.DemoEntity01;

public interface SelfDemoService {
	
	List<DemoEntity> find(DemoEntity entity);
	List<DemoEntity> find2(DemoEntity entity);
	
	List<DemoEntity01> findMore(DemoEntity01 entity);
	void insert(DemoEntity entity);
	
	void insertMore();
	
	void update(DemoEntity entity);
	
	void delete(DemoEntity entity);
	
	List<Map<String, Object>> findGroupQuery();
	
	void myInsert(DemoEntity entity)  throws Exception;
}
