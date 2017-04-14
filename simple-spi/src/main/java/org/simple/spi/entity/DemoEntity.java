package org.simple.spi.entity;

import java.util.Date;

import org.simple.spi.base.IEntity;
/**
 * 测试 用 demo entity
 * @author John
 *
 */
public class DemoEntity extends IEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -859428608181584438L;
	
	public static final String namespace1 = "demoDubbo01";
	public static final String namespace2 = "demoDubbo02";
	
	private Integer id;
	private String name;
	private int age;
	private Date ctime;
	private String className;
	private String tian;
	private String type;

	
	public DemoEntity(){
		
	}
	 
	public DemoEntity(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public DemoEntity(String name,int age,String className,String tian){
		this.name = name;
		this.age = age;
		this.className=className;
		this.tian = tian;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTian() {
		return tian;
	}
	public void setTian(String tian) {
		this.tian = tian;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}
	
	
	
}
