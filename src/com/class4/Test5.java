package com.class4;

public class Test5 {

	public static void main(String[] args) {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("서울");
		sb.append("부산");
		sb.append("대구");
			
	     System.out.println(sb);
	
			 //StringBuilder -> String으로 변환
	     String str = sb.toString();
	     System.out.println(str);
	     
	     //Integer (wrapper class)
	    int a= 24;
	    System.out.println(a);
	    System.out.println(Integer.toString(a));//정수를 문자로 바꿔서 출력한다.
	    System.out.println(Integer.toString(a,2));//2진수
	    System.out.println(Integer.toString(a,16));//16진수
			  

	}
       
}