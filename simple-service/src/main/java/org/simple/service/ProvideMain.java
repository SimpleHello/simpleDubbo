package org.simple.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProvideMain {

	 public static void main(String[] args) throws Exception {  
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(  
	                new String[] { "classpath:conf/applicationContext.xml" });  
	        context.start();
	        System.in.read(); // 为保证服务一直开着，利用输入流的阻塞来模拟  
	    }  

}
