package com.test;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.simple.entity.DemoEntity;
import org.simple.spi.CustomerService;
import org.simple.spi.ProvideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:conf/applicationContext.xml")
public class MongdbTest {

	@Autowired
	CustomerService customerDb;
	
	@Autowired
	ProvideService privodeDb;
	
	@Before
	public void bef(){
		System.out.println("开始单元测试");
	}
	
	@After
	public void aft(){
		System.out.println("测试结束");
	}
	

	@Test
	public void demoTest() throws ParseException{
		String str = customerDb.getFromProviceDemo("李四");
		System.out.println("返回结果:"+str);
		
	}
	
	@Test
	public void insert() throws ParseException{
		DemoEntity entity = new DemoEntity();
		entity.setAge(12);
		entity.setName("张三");
		customerDb.save(entity);	
		System.out.println("保存 成功");
	}
	


	private int getRandom(int min,int max){
		return (int)(min+Math.random()*(max-min+1));
	}
}
