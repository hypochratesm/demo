package com.day6;

public class Test5 {
	
	 public static void main(String[] args){
		 
		 //Class - 클래스는 언어의 가장 포인트. (객체)..클래스는 재사용성이다.
		 
		 Testcom tc = new Testcom();
		 
		 tc.input();
		 int a = tc.area();//int값은 반환값을 담는 그릇
		 int l = tc.length();
		 
		 tc.print(a, l);
		 
		 System.out.println("---------------");
		 
		 tc.input();
		 a = tc.area();
		 l = tc.length();
		 
		 
		 
		 tc.print(a, l);//메소드를 계속 넣어서 새로운 값만 사용하게 되는 것.
		 
		 
		 
		 System.out.println("---------------");
		 
		 
		 Testcom tc1 = new Testcom();
		
		 tc1.input();
		 a = tc1.area();
		 l = tc1.length();
		 tc1.print(a, l);
		 
		 
	 }

}
