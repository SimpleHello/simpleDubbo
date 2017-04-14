package com.test;

import java.text.ParseException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.simple.spi.entity.DemoEntity;
import org.simple.spi.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.service.SelfDemoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= "classpath:conf/applicationContext.xml")
public class DubboTest {

	@Autowired
	DemoService customerService;
	
	@Autowired
	DemoService privodeService;
	
	@Autowired
	SelfDemoService selfDemoService;
	
	
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
		String str = customerService.getName("张三");
//		String str2 = privodeService.getName("customer李四");
		System.out.println("返回结果:"+str);
//		System.out.println("返回结果:"+str2);
	}
	
	@Test
	public void insert(){
		DemoEntity entity = new DemoEntity("张三",0);
		customerService.save(entity);
	}

	@Test
	public void seinsert(){
		DemoEntity entity = new DemoEntity("张三",0);
		selfDemoService.insert(entity);
	}
	private int getRandom(int min,int max){
		return (int)(min+Math.random()*(max-min+1));
	}
}
