package com.class4;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;

public class Test7 {
	
	public static void main(String[] args)throws IOException{
		
		BufferedReader br = new BufferedReader(new
				InputStreamReader(System.in));
		
		System.out.print("수식[3+5]?");//12+30;
		String str = br.readLine();
		
		str = str. replace("\\s", "");
		/*
	    String[] oper = {"+","-","*","/"};
	    for(String op :oper){
	    } 	
*/	    
		for(String op: new String[]{"+","-","*","/"}){//람바다형식
			
		
		
		int pos = str.indexOf(op);
		
		
		if(pos>-1){
			
			int num1 = Integer.parseInt(str.substring(0,pos));
			int num2 = Integer.parseInt(str.substring(pos+1));
			
			int result = 0;
			
			char oper = str.charAt(pos);
			
			switch(oper){
			
			case'+':
				result = num1+num2;
				break;
			case'-':
				result = num1-num2;
				break;
			case'*':
				result = num1*num2;
				break;
			case'/':
				result = num1/num2;
				break;
			}
			System.out.println();//System.out.printf("%d %c %d = %d",num1,oper,num2,result);
			
			String s = String.format("%d %c %d = %d",num1,oper,num2,result);
			
			System.out.println(s);//return s
		}
		
	}
}
}
