package com.day2;

import java.util.*;

class Test6 {

	public static void main(String[] args) {


  Scanner sc = new Scanner(System.in);//Scanner는 기본적으로 공백을 기준으로 구분을 한다.
		
  String name;
  int kor,eng, mat;

  //System.out.print("이름 국어 영어 수학?");//suzi 50 60 70// 버퍼드리더는 문장을 한번에 다 읽지만 스캐너는 공백이 있으면 읽는것을 멈춘다.


  System.out.print("이름 국어 영어 수학?");//suzi 50 60 70
  sc = new Scanner (sc.next()). useDelimiter("\\s*,\\s*");  //Scanner s = new Scanner(input). useDelimiter("\\s*fish\\s*");
   
   name = sc.next();
   kor = sc.nextInt();
   eng = sc.nextInt();
   mat = sc.nextInt();

	System.out.println(name+":"+(kor+eng+mat)+ "점");
	//System.out.println(name+":"+(kor+eng+mat)+ "점");//suzi 50,60,70




	}
}
