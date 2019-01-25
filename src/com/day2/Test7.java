package com.day2;

import java. util.*;

class Test7 {


	public static void main(String[] args) 	{

       //세개의 수를 입력받아 작은순에서 큰순으로 출력
	   //세개의 수? 15 3 7
	   //결과 : 3 5 7
	   //변수는 세개가 필요함
	   //자리바꿈
	   //num을 이용

    Scanner sc = new Scanner(System.in);

	String name;

	int num1,num2,num3,temp;

    System.out.print("세개의 수?");

	
     num1 = sc.nextInt();
	 num2 = sc.nextInt();
     num3 = sc.nextInt();




	
	 if(num1>num2){
		 temp=num1;
		 num1=num2;
		 num2=temp;
	 }
	 if(num1>num3){
		 temp=num1;
		 num1=num3;
		 num3=temp;
	 }
	 if(num2>num3){
		temp=num2;
		num2=num3;
	    num3=temp;
	 }

	 //이 코딩은 외우자
 

	 System.out.printf("%d %d %d\n", num1,num2,num3);
	 System.out.println(num1+""+num2+""+num3);


	}
}
