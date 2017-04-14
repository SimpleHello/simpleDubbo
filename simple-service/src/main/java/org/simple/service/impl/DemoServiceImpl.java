package org.simple.service.impl;

import org.simple.spi.entity.DemoEntity;
import org.simple.spi.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service("provideService")
public class DemoServiceImpl implements DemoService {

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public String getName(String str) {
		// TODO Auto-generated method stub
		return "from service : demoService:"+str;
	}

	@Override
	public void save(DemoEntity entity) {
		// TODO Auto-generated method stub
		int i = 1/entity.getAge();
		mongoTemplate.save(entity, DemoEntity.namespace2);
		System.out.println("####  调用 进去 provide save 成功");
	}

}
