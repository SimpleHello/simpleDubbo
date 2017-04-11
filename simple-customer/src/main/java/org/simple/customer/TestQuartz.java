package org.simple.customer;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestQuartz {

    public void TestMethod(){  
    	
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         System.out.println("**********测试跑批类*** " +sdf.format(new Date()));
   }  
}  