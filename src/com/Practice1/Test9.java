package com.Practice1;

import java.util.Scanner;

class TestA{
	
	public void print(String r){
		System.out.println(r);
	}
	
}

class Calc extends TestA{
	
	private int num1;
	private int num2;
	private int r;
	int j;
	private char oper;
	private String result;
	
	public void set(String s){
		String[] str = s.split(",");
		num1 = Integer.parseInt(str[0]);
		num2 = Integer.parseInt(str[1]);	
	}
	
	public void setLine(String s){
		
		
		for(int i =0; i<s.length();i++){
			if((j=s.indexOf('+'))>-1 ||  (j=s.indexOf('-'))>-1 
					|| (j=s.indexOf('*'))>-1 || (j=s.indexOf('/'))>-1){
				oper = s.charAt(j);
			}
		}
		
		String temp1 = s.substring(0, j);
		String temp2 = s.substring(j+1);
		
		num1 = Integer.parseInt(temp1);
		num2 = Integer.parseInt(temp2);
		
		
	}
	
	public void setOper(String s){
		oper = s.charAt(0);
	}
	
	public String proc(){
		
		switch (oper) {
		case '+':
			r = num1 +num2;
			result = result.format("%d %c %d = %d",num1,oper,num2,num1+num2);
			return result;
		case '-':
			r = num1 +num2;
			result = result.format("%d %c %d = %d",num1,oper,num2,num1-num2);
			return result;
		case '*':
			r = num1 +num2;
			result = result.format("%d %c %d = %d",num1,oper,num2,num1*num2);
			return result;
		case '/':
			r = num1 +num2;
			result = result.format("%d %c %d = %d",num1,oper,num2,num1/num2);
			return result;

		default:
			break;
		}
		return null;
	}
	
}

public class Test9 {

	public static void main(String[] args) {
		
		//두수[5,2]? 10,25
		//연산자?  +
		//10+25=35
		
		
		Calc c = new Calc();
		Scanner sc = new Scanner(System.in);
		
		
		System.out.print("두수[5,2]?");
		String str = sc.next();
		c.set(str);
		System.out.print("연산자?");
		str = sc.next();
		c.setOper(str);
		c.print(c.proc());
		
		
		System.out.print("두수와 연산자[5+2]");
		c.setLine(sc.next());
		c.print(c.proc());
		
		
		
		
	}

}
