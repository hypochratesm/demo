package com.health;

public class HealthVO {
	
	
	private String name;
	private String age;
	private String gender;
	private String addr;
	private String zip;
	private float weight;
	private float height;



	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float f) {
		this.weight = f;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float f) {
		this.height = f;
	}
	
	@Override
	public String toString() {
		
		String str;
		str = String.format(" %6s %4s %4s %4s %4s %5.1f %5.1f",name,age,gender,addr,zip,weight,height);
		
		return str;
	}
	
}