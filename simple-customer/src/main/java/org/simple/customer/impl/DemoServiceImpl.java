package org.simple.customer.impl;

import org.simple.spi.entity.DemoEntity;
import org.simple.spi.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


@Service("customerService")
public class DemoServiceImpl implements DemoService {


	@Autowired
	MongoTemplate mongoTemplate;
	
	@Autowired
	DemoService privodeService;
	
	@Override
	public String getName(String str) {
		// TODO Auto-generated method stub
		if("张三".equals(str)){
			str = str +" *** "+ privodeService.getName(str); 
		}
		return "from customer ::" + str;
	}

	@Override
	public void save(DemoEntity entity) {
		// TODO Auto-generated method stub
		mongoTemplate.save(entity, DemoEntity.namespace1);
		System.out.println("####  customer save 成功!");
		privodeService.save(entity);
		
	}

}
