package org.simple.customer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CostomerMain {
	public static void main(String[] args) throws Exception {  
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(  
                new String[] { "classpath:conf/applicationContext.xml" });  
        context.start();  
        System.in.read();  
    }  
}

