package org.simple.spi.entity;

import java.io.Serializable;
/**
 * 测试 用 demo entity
 * @author John
 *
 */
public class DemoEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -859428608181584438L;
	
	public static final String namespace1 = "demoDubbo01";
	public static final String namespace2 = "demoDubbo02";
	
	private String name;
	private int age;
	
	public DemoEntity(){
		
	}
	 
	public DemoEntity(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
