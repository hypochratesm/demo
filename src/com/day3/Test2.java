package com.day3;

import java.util.*;

class Test2 {



	public static void main(String[] args) {


		//10보다 큰 수 를 입력받아 1부터 합계 구하기


	   Scanner sc = new Scanner(System.in);

	   int su,sum=0;//sum에는 쓰레기 값이 적혀 있는데 이를 초기화 시키지 않으면 연산이 불가능
	    //초기화는 sum=0으로 시켜주는 것.

	   do{

	      System.out.print("수 입력");//100
	      su = sc.nextInt();

	   }while(su<10);//안돼요

	   //연산작업
/*
	   for(int i=1; i<=su;i++){

		   sum=sum+i;
	   }


	   System.out.println("결과"+ sum);
	   */


        int i=0;
		while(i<su){

			i++;
			sum+=i;//누적
		}


	    System.out.println("결과"+ sum);

	
	}
}
