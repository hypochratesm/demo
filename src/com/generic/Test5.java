package com.generic;

import java.util.Scanner;

import com.exec.MyException;

//5~10자 이내의 문자열을 입력받아 출력
//문자열?abcde
//abcde

//조건

//5~10자 이내의 숫자열을 만들어 보기

//1. 5~10자인지 확인//첫번째 검사
//2.반드시 영문자(대소문자 구분없이)만 입력
//exception으로 처리해준다. -> 사용자가 입력한 값을 

public class Test5 {
	
	
	public void inputForm(String str) throws Exception{
		//조건 1.2
		//스플릿으로도 해보기!
		//매우 중요함
		
		
		

		if(str.length()<5|| str.length()>10){
			
			throw new MyException("문자열의 길이는 5~10자 입니다." + str);//메소드 생성
			
		}
	    for(int i=0;i<str.length();i++){
	    	
	    	char ch = str.charAt(i);
	    	
	    	if((ch<65||ch>90)&&ch<97||ch>122){
	    		
	    		throw new Exception("영문자만 가능합니다!");
	    		
	    	}
	    }
	}

	
	public static void main(String[] args){
		
		
		Scanner sc = new Scanner(System.in);
		
		String str;
		
		Test5 ob = new Test5();
		
		try {
			
			System.out.println("문자열?");
			str = sc.next();
			
			ob.inputForm(str);
			
			System.out.println(str);
			
			
			
		} catch (Exception e) {
			
			System.out.println(e.toString());
			
			
		}
		
		
		
		
	}

}
