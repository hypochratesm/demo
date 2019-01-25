package com.generic;

public class Test6 {//에러를 다시 던지는 방법
	
	public void value1(int value) throws Exception{
		
	 try {
		 
		 
		 value2(value);
		
	} catch (Exception e) {
		System.out.println("value1");
	}
		
	}
	
	public void value2(int value) throws Exception{
		
		if(value<0)
			
			throw new Exception("0보다 작은수!!");
		
		
	}

	public static void main(String[] args) {
		
		
		Test6 ob =new Test6();
		
		
		try {
			
			ob.value1(-10);
			
		} catch (Exception e) {
			System.out.println("main...");
		}

	}

}
