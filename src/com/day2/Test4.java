package com.day2;

import java.io.*;

class Test4 {



	public static void main(String[] args) throws IOException {

         //제어문
		 //if,for,while,do~while,switch
		 //반복문 : for,while,do~while
		 //for문은 범위가 정해져 있을때
		 //while문은 몇번을 돌려야 할지 모를때 사용하는것
		 //do~while문은 일단 저질러 본다.

		 BufferedReader br = new BufferedReader(
			new InputStreamReader(System.in));

		 int num = 0;
		 String str =null;//""=""은 아무것도 없다 라는 뜻

		 System.out.print("수입력?");
		 num= Integer.parseInt(br.readLine());


         //단일 if문


/*
		 if(num%2==0){
			 str="짝수";
		 }
		 //실행문이 한줄일때는 중괄호가 생략 가능하다.
		

		 if(num%2!=0)
			 str="홀수";
*/

         if(num%2==0){
		  str="짝수";
	     }else{
		str="홀수";
	}

		 
		 System.out.println(str);

		
	}
}
