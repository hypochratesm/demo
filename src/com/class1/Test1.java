package com.class1;

import com.day6.Testcom;

public class Test1 {
	
	 int w,h;
	
	public static void main(String[] args){
		
        Testcom tc = new Testcom();
        Testcom tc1 = new Testcom(); 
		 
        tc1.input();tc.input();
		 int a = tc.area();//int값은 반환값을 담는 그릇
		 int l = tc.length();
		 tc.print(a, l);
		 
		 
	
		
		 
		
		 a = tc1.area();
		 l = tc1.length();
		 tc1.print(a, l);
		 
		 System.out.println("tc.w:" + tc.w);
		 System.out.println("tc1.w:" + tc1.w);
		 
		
		/*Testcom tc = new Testcom();
		Testcom tc1 = new Testcom();
		
		tc1.input(); tc.input();
		 int a = tc. area();// int값은 반환값을 담는 그릇
		 int l = tc.length();
		 tc.print(a, l);
		 
		 
		 a = tc1.area();
		 l = tc1.length();
		 tc1.print(a, l);
		 
		 System.out.println("tc.w" + tc.w);
		 System.out.println("tc1.w:" + tc1.w);
	
	      
	      
		 
		
		
*/
	}

}
