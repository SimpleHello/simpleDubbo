package com.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
	DemoService demoService;
	
	@Autowired
	SelfDemoService selfDemoService;
	
	private Date befTime;
	private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
	@Before
	public void bef(){
		befTime = new Date();
		System.out.println("######  开始单元测试:"+ sdf.format(new Date()));
	}
	
	@After
	public void aft(){
		Long mins = new Date().getTime()-befTime.getTime();
		System.out.println("######  测试结束:"+ sdf.format(new Date())+" 耗时："+mins+"毫秒--");
	}
	

	@Test
	public void demoTest() throws ParseException{
//		List<String> list1 = customerService.getList();
//		List<String> list2 = privodeService.getList();
		List<String> list3 = demoService.getList();
//		show(list1,"customerService");
//		show(list2,"privodeService");
		show(list3,"demoService");
	}
	
	@Test
	public void insert(){
		DemoEntity entity = new DemoEntity("张三",0);
		customerService.save(entity);
	}

	@Test
	public void seinsert() throws Exception{
		DemoEntity entity = new DemoEntity("张三",11);
		selfDemoService.myInsert(entity);
	}
	private int getRandom(int min,int max){
		return (int)(min+Math.random()*(max-min+1));
	}
	
	public void show(List<String> list,String name){
		System.out.println("$$$$: "+ name+ "  -------↓↓↓↓↓↓----------");
		if(list!=null&&list.size()>0){
			for(String str:list){
				System.out.println("返回结果:"+str);
			}
		}
		System.out.println("-------↑↑↑↑↑↑- 共："+ list.size() +"------------");
	}
}
