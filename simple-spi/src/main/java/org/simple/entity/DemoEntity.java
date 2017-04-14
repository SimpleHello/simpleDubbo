package org.simple.entity;

import java.io.Serializable;

public class DemoEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1920131170855416935L;
	public static final String namespace1 = "demoDubbo01";
	public static final String namespace2 = "demoDubbo02";
	private String name;
	private int age;
	
	
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
